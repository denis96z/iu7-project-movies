package ru.bmstu.iu7.topmovies.backend.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureDataMongo
public class MovieServiceTests {
    @Autowired
    private MovieService movieService;

    @Test
    public void postMovie_MovieCreated() {
        var movie = this.generateMovie();

        Assert.assertTrue(this.movieService
                .postMovie(movie).isPresent());
    }

    private Movie generateMovie() {
        return new Movie(); //TODO
    }
}
