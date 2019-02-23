package ru.bmstu.iu7.topmovies.backend.service;

import ru.bmstu.iu7.topmovies.backend.domain.Movie;

import java.util.Optional;

public interface MovieService {
    Optional<Movie> postMovie(Movie newMovie);

    Iterable<Movie> getTopMoviesList(Integer limit);

    Optional<Movie> getMovie(String movieId);

    Optional<Movie> patchMovie(String movieId, Movie movieUpdate);

    Optional<?> deleteMovie(String movieId);
}
