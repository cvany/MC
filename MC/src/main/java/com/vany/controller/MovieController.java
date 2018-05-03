package com.vany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vany.entity.Movie;
import com.vany.entity.Result;
import com.vany.service.MovieService;
import com.vany.utils.ResultUtil;

@RestController
public class MovieController {
	@Autowired
	MovieService movieService;
	
	@RequestMapping("findMoviesByPageLastId")
	public Result<List<Movie>> findMoviesByPageLastId(Integer id) {
		List<Movie> list = movieService.findMoviesByPageLastId(id);
		return ResultUtil.success(list);
	}
	
	@RequestMapping("findMovieById")
	public Result<Movie> findMovieById(Integer id){
		Movie movie = movieService.findMovieById(id);
		return ResultUtil.success(movie);
	}
	
	@RequestMapping("updateMovieViewCount")
	public Result<?> updateMovieViewCount(Integer viewCount, Integer id) {
		movieService.updateMovieViewCount(viewCount, id);
		return ResultUtil.success();
	}

}
