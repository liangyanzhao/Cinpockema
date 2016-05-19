package com.c09.cinpockema.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c09.cinpockema.entities.Movie;
import com.c09.cinpockema.entities.MovieComment;
import com.c09.cinpockema.entities.User;
import com.c09.cinpockema.entities.repositories.MovieCommentRepository;
import com.c09.cinpockema.entities.repositories.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieCommentRepository movieCommentRepository;
	
	public Iterable<Movie> listMovies() {
		return movieRepository.findAll();
	}
	
	public Movie getMovieById(long id) {
		return movieRepository.findOne(id);
	}
	
	public List<MovieComment> listCommentsByMovieId(long id) {
		return movieCommentRepository.findByMovieId(id);
	}
	
	public void createMovie(Movie movie) {
		movieRepository.save(movie);
	}
	
	public void createComment(MovieComment movieComment, Movie movie, User user) {
        movieComment.setUser(user);
        movie.addMovieComment(movieComment);
        movieRepository.save(movie);
	}
	
	public void deleteCommentById(User user, long id) {
//		movieCommentRepository.deleteByUserIdAndId(user.getId(), id);
	}
	
	public Movie updateMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public void deleteMovieById(long id) {
		movieRepository.delete(id);
	}
	
	
}