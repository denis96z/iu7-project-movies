package ru.bmstu.iu7.topmovies.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bmstu.iu7.topmovies.backend.constant.Limit;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;
import ru.bmstu.iu7.topmovies.backend.service.MovieService;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> getTopMovies(@RequestParam(name = "limit",
            required = false, defaultValue = Limit.DEFAULT_MOVIES_LIMIT) Integer limit) {
        var list = this.movieService.getTopMoviesList(limit);
        return ResponseEntity.ok(list);
    }
}
