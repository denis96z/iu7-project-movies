package ru.bmstu.iu7.topmovies.backend.controller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;
import ru.bmstu.iu7.topmovies.backend.service.MovieService;

import java.util.Optional;

public class MovieControllerTests {
    @Test
    public void createMovie_MovieCreated() {
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
}
