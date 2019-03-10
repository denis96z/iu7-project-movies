package ru.bmstu.iu7.topmovies.backend.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataMongo
public class MovieServiceTest {
    @Autowired
    private MovieService movieService;



    @Test
    public void postMovie_MovieCreated() {

        var movie = this.generateMovie();
        Assert.assertTrue(this.movieService
                .postMovie(movie).isPresent());
    }

    @Test
    public void getMovie_MovieFound() {

        var movie = this.generateMovie();
        movie.setId(null);
        var newMovie = this.movieService.postMovie(movie);

        Assert.assertEquals(newMovie, this.movieService.getMovie(newMovie.get().getId()));
    }

    @Test
    public void deleteMovie_MovieDeleted() {

        var movie = this.generateMovie();
        movie.setId(null);
        var newMovie = this.movieService.postMovie(movie);

        Assert.assertEquals(newMovie, this.movieService.deleteMovie(newMovie.get().getId()));
    }

    @Test
    public void patchMovie_MovieParamChange() {

        var movie = this.generateMovie();
        movie.setId(null);
        var newMovie = this.movieService.postMovie(movie);

        movie.setTitle("Operaion Ib");

        var pachedMovie = this.movieService.patchMovie(newMovie.get().getId(), movie);

        Assert.assertEquals(newMovie, this.movieService.deleteMovie(newMovie.get().getId()));
    }

    @Test
    public void getTopMoviesList_MovieListGot() {

        var movie = this.generateMovie();
        movie.setId(null);
        movie.setRating((float) 1);
        var newMovie = this.movieService.postMovie(movie);

        var test = false;

        Iterable<Movie> listMovie = this.movieService.getTopMoviesList(1);
        List<Movie> target = new ArrayList<>();
        listMovie.forEach(target::add);

        if (target.get(0).equals(newMovie) ) {
            test = true;
        }

        Assert.assertTrue(test);
    }


    private Movie generateMovie() {
        return new Movie(); //TODO
    }
}