package com.sainath.movies;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "*")
public class MovieController {
	@Autowired
	private MovieService movieService;
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {
		return new ResponseEntity<List<Movie>>(movieService.allMovies(),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movie> getOneMovie(@PathVariable ObjectId id){
		
		return new ResponseEntity<Movie>(movieService.OneMovie(id),HttpStatus.OK);
	}
	@GetMapping("/imdbId/{imdbId}")
	public ResponseEntity<Movie> getOneMovie(@PathVariable String imdbId){
		
		return new ResponseEntity<Movie>(movieService.movieByImdbId(imdbId),HttpStatus.OK);
	}
}
