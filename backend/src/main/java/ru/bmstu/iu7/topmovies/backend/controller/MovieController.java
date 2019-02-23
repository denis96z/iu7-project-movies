package ru.bmstu.iu7.topmovies.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    //получить информацию о фильмах
    //параметр 1 - количество фильмов
    @GetMapping
    public ResponseEntity<Iterable<Movie>> getTopMovies(@RequestParam(name = "limit",
            required = false, defaultValue = Limit.DEFAULT_MOVIES_LIMIT) Integer limit) {
        var list = this.movieService.getTopMoviesList(limit);
        return ResponseEntity.ok(list);
    }

    @PostMapping
    public ResponseEntity<?> postMovie(@RequestBody Movie newMovie) {
        this.movieService.postMovie(newMovie);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Movie> getMovieInfo(@RequestBody String idMovie) {
        var findMovie = this.movieService.getMovieInfo(idMovie);
        return ResponseEntity.ok(findMovie);
    }

    @PostMapping
    public ResponseEntity<?> patchMovie(@RequestBody String idMovie, @RequestBody Movie patchedMovie) {
        this.movieService.patchMovie(idMovie, patchedMovie);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> deleteMovie(@RequestBody String idMovie) {
        this.movieService.deleteMovie(idMovie);
        return ResponseEntity.ok().build();
    }
}
