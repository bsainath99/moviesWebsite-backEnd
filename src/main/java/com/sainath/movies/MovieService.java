package com.sainath.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	public List<Movie> allMovies(){
		return movieRepository.findAll();
	}
	public Movie OneMovie(ObjectId id) {
		return movieRepository.findById(id).get();
	}
	public Movie movieByImdbId(String id) {
		return movieRepository.findByImdbId(id);
	}
}
