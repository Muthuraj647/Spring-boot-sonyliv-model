package com.muthu.sampleProject.Sony_Live.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieslist")
public class MoviesEntity {
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "moviename")
	private String movieName;
	
	@Column(name = "actorname")
	private String actorName;
	
	@Column(name = "language")
	private String language;
	
	@Column(name = "userid")
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public MoviesEntity(int id, String movieName, String actorName, String language,int userId) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.actorName = actorName;
		this.language = language;
		this.userId=userId;
	}

	public MoviesEntity() {
		super();
	}

	public MoviesEntity(int userId) {
		// TODO Auto-generated constructor stub
		this.userId=userId;
	}
	
	
}
