package com.vany.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.vany.entity.Movie;
import com.vany.repository.MovieRepository;

/**
 * 定时器，每天凌晨4点，向http://tuan.sogou.com/dianyingpiao/?fr=yingshi
 * 获取电影资源
 * @author van元
 *
 */
@Component
public class Scheduler {
	@Autowired
	MovieRepository movieRepository;
	
	/**
	 * 每天准时凌晨4点获取电影资源
	 */
	@Scheduled(cron = "0 0 4 * * ?")  
	public void timer(){  
	    //获取当前时间  
	    LocalDateTime localDateTime =LocalDateTime.now();  
	    System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));  
	    saveNewMovieAndUpdateMoviePoint();
	}
	
	//将新电影资源保存到数据库
	private void saveNewMovieAndUpdateMoviePoint() {
		List<Movie> movieList =getMovieResource();
		List<Movie> all = movieRepository.findAll();
		for(int i=0;i<movieList.size();i++) {
			/**
			 * 修复一个bug，当主演姓名总长度大于等于10的时候才添加到数据库
			 * 这样是为了防止在小程序中图片大小显示参差不齐
			 */
			int movieActorsLength =movieList.get(i).getMovieActor().length();
			if (movieActorsLength<10) {
				continue;
			}
			
			String movieName = movieList.get(i).getMovieName();
			String moviePoint = movieList.get(i).getMoviePoint();
			Boolean flag =false;
			int index =0;
			//以下是遍历数据库中数据库，如果从网络上获取的电影资源片名已经存在数据库中，则flag置为true
			//（之所以将数据库中数据全部拿出来进行车程序遍历，是为了提高效率）
			for(int j=0;j<all.size();j++) {
				if(movieName.equals(all.get(j).getMovieName())) {
					flag =true;
					index =j;	//记录该角标
				}
			}
			//判断flag是否为true，如果为true，则该影片已经存在数据库中
			if(flag) {
				Movie movie = all.get(index);
				//判断评分是否一样，如果不一样则更新评分
				if(!moviePoint.equals(all.get(index).getMoviePoint())) {
					movie.setMoviePoint(moviePoint);
				}
				//判断片长是否一样
				if (!movieList.get(i).getMovieLength().equals(all.get(index).getMovieLength())) {
					movie.setMoviePoint(movieList.get(i).getMovieLength());
				}
				//判断地区是否一样
				if (!movieList.get(i).getMovieArea().equals(all.get(index).getMovieArea())) {
					movie.setMovieArea(movieList.get(i).getMovieArea());
				}
				//判断类型是否一样
				if (!movieList.get(i).getMovieType().equals(all.get(index).getMovieType())) {
					movie.setMovieType(movieList.get(i).getMovieType());
				}
				//判断导演是否一样
				if (!movieList.get(i).getMovieDiretor().equals(all.get(index).getMovieDiretor())) {
					movie.setMovieDiretor(movieList.get(i).getMovieDiretor());
				}
				//判断主演是否一样
				if (!movieList.get(i).getMovieActor().equals(all.get(index).getMovieActor())) {
					movie.setMovieActor(movieList.get(i).getMovieActor());
				}
				movieRepository.save(movie);
			}
			else {//如果flag为false，则该影片不存在数据库中，则需要插入到数据库
				movieRepository.save(movieList.get(i));
			}
		}
	}
	
	//获取电影资源
	private List<Movie> getMovieResource(){
		List<Movie> list =new ArrayList<Movie>();
		try {
			Document doc = Jsoup.connect("http://tuan.sogou.com/dianyingpiao/?fr=yingshi").get();
			Elements movieName = doc.select("div[style*=display:block] h3 a");
			Elements moviePoint = doc.select("div[style*=display:block] div.rater-num");
			Elements moviePhoto = doc.select("div[style*=display:block] a.imginfo-img");
			Elements resource = doc.select("div[style*=display:block] p");
			int i = 0;
			Movie movie =null;
			for (int n = 0; n < movieName.size(); n++) {
				movie =new Movie();
				movie.setMovieName(movieName.get(n).html());
				String tem = moviePhoto.get(n).html();
				String src = tem.substring(tem.indexOf("https"), tem.lastIndexOf(".jpg") + 4);
				movie.setMoviePhoto(src);
				movie.setMoviePoint(moviePoint.get(n).html());
				int j = 0;
				for (; i < resource.size() && j < 5; i++) {
					String temp = resource.get(i).html();
					String s = temp.substring(temp.indexOf("</span>") + 7);
					switch (j) { 
					case 0:
						movie.setMovieLength(s);
						break;
					case 1:
						movie.setMovieArea(s);
						break;
					case 2:
						movie.setMovieType(s);
						break;
					case 3:
						movie.setMovieDiretor(s);
						break;
					case 4:
						movie.setMovieActor(s);
						break;
					}
					j++;
				}
				list.add(movie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
