package com.muthu.sampleProject.Sony_Live.UserService.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muthu.sampleProject.Sony_Live.CustomException.ResourceNotFoundException;
import com.muthu.sampleProject.Sony_Live.Entity.MoviesEntity;
import com.muthu.sampleProject.Sony_Live.Entity.Users;
import com.muthu.sampleProject.Sony_Live.SonyRepository.CentralRepository;
import com.muthu.sampleProject.Sony_Live.SonyRepository.MoviesRepository;
import com.muthu.sampleProject.Sony_Live.UserService.MoviesService;

@Service
public class MoviesServiceImpl implements MoviesService {

	private MoviesRepository moviesRepository;
	
	@Autowired
	private CentralRepository repo;
	
	
	public MoviesServiceImpl(MoviesRepository moviesRepository) {
		super();
		this.moviesRepository = moviesRepository;
	}


	@Override
	public List<MoviesEntity> getMovies(int userid) {
		
		List<MoviesEntity> list=moviesRepository.getMoviesByID(userid);
		
		return list;
	}


	


	@Override
	public void addMovies(MoviesEntity moviesEntity) {
		
		moviesRepository.save(moviesEntity);
		
	}


	@Override
	public MoviesEntity getMovie(int id) {
		
		MoviesEntity movie=moviesRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Movie ", "Id", id));
		
		
		return movie;
	}


	@Override
	public void updateMovie(int id,MoviesEntity moviesEntity) {
		
		MoviesEntity movie=moviesRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Movie ", "Id", id));
		
		movie.setMovieName(moviesEntity.getMovieName());
		movie.setActorName(moviesEntity.getActorName());
		movie.setLanguage(moviesEntity.getLanguage());
		moviesRepository.save(movie);
	}


	@Override
	public void deleteMovie(int id) {
		
		MoviesEntity movie=moviesRepository.findById(id).orElseThrow(()
				-> new ResourceNotFoundException("Movie ", "Id", id));
		moviesRepository.delete(movie);
		
	}


	@Override
	public List<MoviesEntity> searchMovies(String key) {
		
		List<MoviesEntity> list=moviesRepository.getMoviesByActorName(key);
		
		return list;
	}
	

}
