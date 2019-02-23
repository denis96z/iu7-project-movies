package ru.bmstu.iu7.topmovies.backend.service;

import ru.bmstu.iu7.topmovies.backend.domain.Movie;

import java.util.Optional;

public interface MovieService {
    Iterable<Movie> getTopMoviesList(Integer limit);
    Movie postMovie(Movie newMovie);
    Optional<Movie> getMovieInfo(String idMovie);
    void patchMovie(String idMovie, Movie patchedMovie);
    void deleteMovie(String idMovie);
}
