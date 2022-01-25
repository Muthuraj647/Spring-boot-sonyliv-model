package com.muthu.sampleProject.Sony_Live.SonyRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.muthu.sampleProject.Sony_Live.Entity.MoviesEntity;

public interface MoviesRepository extends JpaRepository<MoviesEntity, Integer> {
	
	//jpql query
	@Query("from MoviesEntity where actorname=?1")
	List<MoviesEntity> getMoviesByActorName(String actorname);
	
	@Query("from MoviesEntity where userid=?1")
	List<MoviesEntity> getMoviesByID(int userid);

}
