package com.vany.service;

import java.util.List;

import com.vany.entity.Movie;

public interface MovieService {
	
	/**
	 * 根据每页最后一条记录id分页查询
	 * 默认每页10条数据
	 * @param id 每页最后一条记录id
	 * @return
	 */
	List<Movie> findMoviesByPageLastId(Integer id);
	
	/**
	 * 根据id查找电影
	 * @param id
	 * @return
	 */
	Movie findMovieById(Integer id);
	
	/**
	 * 更新电影查看数
	 * @param viewCount
	 * @param id
	 */
	void updateMovieViewCount(Integer viewCount,Integer id);

}
