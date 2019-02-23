package ru.bmstu.iu7.topmovies.backend.service;

import com.fasterxml.jackson.databind.JsonSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;
import ru.bmstu.iu7.topmovies.backend.repository.MovieRepository;
import ru.bmstu.iu7.topmovies.backend.constant.Limit;

import java.util.Optional;


@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Iterable<Movie> getTopMoviesList(Integer limit) {
        Pageable syslimit;
        if (limit == 0 ){
            syslimit = PageRequest.of(0, Limit.DEFAULT_MOVIES_LIMIT);
        }else{
            syslimit = PageRequest.of(0, limit);
        }
        //throw new RuntimeException("Movie list got");
        return  movieRepository.findAll(syslimit);
    }

    @Override
    public Movie postMovie(Movie newMovie) {
        //throw new RuntimeException("Movie posted");
        return movieRepository.insert(newMovie);
    }

    @Override
    public Optional<Movie> getMovieInfo(String idMovie) {
        return movieRepository.findById(idMovie);
        //throw new RuntimeException("Movie info");
    }

    @Override
    public void patchMovie(String idMovie, Movie patchedMovie) {
        deleteMovie(idMovie);
        postMovie(patchedMovie);
        //throw new RuntimeException("Movie patched");
    }

    @Override
    public void deleteMovie(String idMovie) {
        movieRepository.deleteById(idMovie);
        //throw new RuntimeException("Movie deleted");
    }
}
