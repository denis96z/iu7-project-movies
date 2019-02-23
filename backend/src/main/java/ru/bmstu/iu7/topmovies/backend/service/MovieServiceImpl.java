package ru.bmstu.iu7.topmovies.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;
import ru.bmstu.iu7.topmovies.backend.repository.MovieRepository;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Optional<Movie> postMovie(Movie newMovie) {
        return Optional.of(this.movieRepository.save(newMovie));
    }

    @Override
    public Iterable<Movie> getTopMoviesList(Integer limit) {
        var page = PageRequest.of(0, limit,
                Sort.by(Sort.Direction.DESC, "rating"));
        return this.movieRepository.findAll(page).getContent();
    }

    @Override
    public Optional<Movie> getMovie(String movieId) {
        return this.movieRepository.findById(movieId);
    }

    @Override
    public Optional<Movie> patchMovie(String movieId, Movie movieUpdate) {
        var movie = this.movieRepository.findById(movieId);
        if (movie.isEmpty()) {
            return Optional.empty();
        }
        movieUpdate.setId(movieUpdate.getId());
        return Optional.of(this.movieRepository.save(movieUpdate));
    }

    @Override
    public Optional<?> deleteMovie(String movieId) {
        var movie = this.movieRepository.findById(movieId);
        if (movie.isEmpty()) {
            return Optional.empty();
        }
        this.movieRepository.deleteById(movieId);
        return movie;
    }
}
