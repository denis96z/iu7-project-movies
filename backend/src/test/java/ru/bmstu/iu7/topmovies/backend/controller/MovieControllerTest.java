package ru.bmstu.iu7.topmovies.backend.controller;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;
import ru.bmstu.iu7.topmovies.backend.service.MovieService;

import java.util.ArrayList;
import java.util.Optional;

public class MovieControllerTest {


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
                        movieController.getTopMovies(10));
    }


    @Test
    public void getTopMovies_LimitMinus_ReturnsBadRequest() {

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.getTopMoviesList(Mockito.anyInt()))
                .thenThrow(RuntimeException.class);

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.badRequest().build(),
                        movieController.getTopMovies(-1));
    }

    @Test
    public void getTopMovies_LimitZero_ReturnsBadRequest() {

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.getTopMoviesList(Mockito.anyInt()))
                .thenThrow(RuntimeException.class);

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.badRequest().build(),
                        movieController.getTopMovies(0));
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
                        movieController.getTopMovies(50));
    }

    @Test
    public void getTopMovies_TopLimit_ReturnsList() {
        var moviesList = new ArrayList<Movie>();
        moviesList.add(new Movie());

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.getTopMoviesList(Mockito.anyInt()))
                .thenReturn(moviesList);

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.ok(moviesList),
                        movieController.getTopMovies(100));
    }

    @Test
    public void getTopMovies_OverLimit_ReturnsBadRequest() {

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.getTopMoviesList(Mockito.anyInt()))
                .thenThrow(RuntimeException.class);

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.badRequest().build(),
                        movieController.getTopMovies(101));
    }

    @Test
    public void patchMovie_MoviePatched_ReturnsOk() {
        var movie = new Movie();
        var movie2 = new Movie();

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.patchMovie(movie.getId(), movie2))
                .thenReturn(Optional.of(movie));

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.ok(movie),
                        movieController.patchMovie(movie.getId(), movie2));
    }

    @Test
    public void patchMovie_MovieNotFound_ReturnsResponse() {
        var movie = new Movie();
        var movie2 = new Movie();

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.patchMovie(movie2.getId(), movie))
                .thenReturn(Optional.empty());

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.notFound().build(),
                        movieController.patchMovie(movie2.getId(), movie));
    }

    @Test
    public void deleteMovie_MovieExists_ReturnsOk() {
        var movie = new Movie();

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .doReturn(Optional.of(movie))
                .when(mockService)
                .deleteMovie(Mockito.anyString());

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.ok().build(),
                        movieController.deleteMovie(Mockito.anyString()));
    }

    @Test
    public void deleteMovie_MovieNotFound_ReturnsResponse() {
        var movie = new Movie();

        var mockService = Mockito.mock(MovieService.class);
        Mockito
                .when(mockService.deleteMovie(Mockito.anyString()))
                .thenThrow(RuntimeException.class);

        var movieController = new MovieController(mockService);

        Assert
                .assertEquals(ResponseEntity.notFound().build(),
                        movieController.deleteMovie(movie.getId()));
    }

}