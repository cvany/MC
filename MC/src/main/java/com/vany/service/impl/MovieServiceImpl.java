package com.vany.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vany.entity.Movie;
import com.vany.repository.MovieRepository;
import com.vany.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieRepository movieRepository;

	public List<Movie> findMoviesByPageLastId(Integer id) {
		//如果为0，说明是第1页，则将id=Integer.MAX_VALUE
		if(id==0) {
			id=Integer.MAX_VALUE;
		}
		return movieRepository.findMoviesByPageLastId(id);
	}
	
	public Movie findMovieById(Integer id) {
		return movieRepository.findOne(id);
	}

	@Transactional
	public void updateMovieViewCount(Integer viewCount, Integer id) {
		viewCount+=1;
		movieRepository.updateMovieViewCount(viewCount, id);
	}

	

}
