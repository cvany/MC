package com.vany.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.vany.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	@Query(value="select * from movie where id<?1 order by id desc limit 10",nativeQuery=true)
	List<Movie> findMoviesByPageLastId(Integer id);
	
	@Modifying
	@Query(value="update movie set view_count =?1 where id=?2",nativeQuery=true)
	void updateMovieViewCount(Integer viewCount,Integer id);

}
