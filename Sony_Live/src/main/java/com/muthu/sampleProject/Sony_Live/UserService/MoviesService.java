package com.muthu.sampleProject.Sony_Live.UserService;

import java.util.List;

import com.muthu.sampleProject.Sony_Live.Entity.MoviesEntity;

public interface MoviesService {

	public List<MoviesEntity> getMovies(int id);
	
	//check on user table
	
	
	
	public void addMovies(MoviesEntity moviesEntity);
	
	public MoviesEntity getMovie(int id);
	
	public void updateMovie(int id,MoviesEntity moviesEntity);
	
	public void deleteMovie(int id);
	
	public List<MoviesEntity> searchMovies(String key);
	
}
