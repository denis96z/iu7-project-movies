package ru.bmstu.iu7.topmovies.backend.service;

import ru.bmstu.iu7.topmovies.backend.domain.Movie;

public interface MovieService {
    Iterable<Movie> getTopMoviesList(Integer limit);
}
