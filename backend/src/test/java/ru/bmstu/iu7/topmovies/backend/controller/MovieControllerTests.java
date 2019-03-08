package ru.bmstu.iu7.topmovies.backend.controller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;
import ru.bmstu.iu7.topmovies.backend.service.MovieService;

import java.util.ArrayList;
import java.util.Optional;

public class MovieControllerTests {
    @Test
    public void createMovie_MovieCreated_ReturnsMovie() {
        var movie = new Movie();

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.postMovie(Mockito.any()))
                .thenReturn(Optional.of(movie));

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.ok(movie),
                        movieController.postMovie(movie));
    }

    @Test
    public void getTopMovies_NoMovies_ReturnsEmptyList() {
        var emptyList = new ArrayList<Movie>();

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.getTopMoviesList(Mockito.anyInt()))
                .thenReturn(emptyList);

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.ok(emptyList),
                        movieController.getTopMovies(Mockito.anyInt()));
    }

    @Test
    public void getTopMovies_MoviesFound_ReturnsList() {
        var moviesList = new ArrayList<Movie>();
        moviesList.add(new Movie());

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.getTopMoviesList(Mockito.anyInt()))
                .thenReturn(moviesList);

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.ok(moviesList),
                        movieController.getTopMovies(Mockito.anyInt()));
    }
}
