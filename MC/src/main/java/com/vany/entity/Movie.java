package com.vany.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String moviePhoto;
	private String movieName;
	private String moviePoint;
	private String movieLength;
	private String movieArea;
	private String movieType;
	private String movieDiretor;
	private String movieActor;
	private Integer viewCount=0;	//默认值为0
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMoviePhoto() {
		return moviePhoto;
	}
	public void setMoviePhoto(String moviePhoto) {
		this.moviePhoto = moviePhoto;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMoviePoint() {
		return moviePoint;
	}
	public void setMoviePoint(String moviePoint) {
		this.moviePoint = moviePoint;
	}
	public String getMovieLength() {
		return movieLength;
	}
	public void setMovieLength(String movieLength) {
		this.movieLength = movieLength;
	}
	public String getMovieArea() {
		return movieArea;
	}
	public void setMovieArea(String movieArea) {
		this.movieArea = movieArea;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieDiretor() {
		return movieDiretor;
	}
	public void setMovieDiretor(String movieDiretor) {
		this.movieDiretor = movieDiretor;
	}
	public String getMovieActor() {
		return movieActor;
	}
	public void setMovieActor(String movieActor) {
		this.movieActor = movieActor;
	}
	
	public Integer getViewCount() {
		return viewCount;
	}
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", moviePhoto=" + moviePhoto + ", movieName=" + movieName + ", moviePoint="
				+ moviePoint + ", movieLength=" + movieLength + ", movieArea=" + movieArea + ", movieType=" + movieType
				+ ", movieDiretor=" + movieDiretor + ", movieActor=" + movieActor + ", viewCount=" + viewCount + "]";
	}
	
}
