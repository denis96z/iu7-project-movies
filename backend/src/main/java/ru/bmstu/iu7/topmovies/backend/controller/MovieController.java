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

    @PostMapping
    public ResponseEntity<Movie> postMovie(@RequestBody Movie newMovie) {
        var instance = this.movieService.postMovie(newMovie);
        return instance.map(ResponseEntity::ok)
                .orElseThrow(RuntimeException::new);
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> getTopMovies(@RequestParam(name = "limit",
            required = false, defaultValue = Limit.DEFAULT_MOVIES_LIMIT) Integer limit) {
        var list = this.movieService.getTopMoviesList(limit);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Movie> getMovie(@PathVariable("movieId") String movieId) {
        var instance = this.movieService.getMovie(movieId);
        if (instance.isPresent()) {
            return ResponseEntity.ok(instance.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PatchMapping("/{movieId}")
    public ResponseEntity<Movie> patchMovie(@PathVariable("movieId") String movieId,
                                            @RequestBody Movie movieUpdate) {
        var instance = this.movieService.patchMovie(movieId, movieUpdate);
        if (instance.isPresent()) {
            return ResponseEntity.ok(instance.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<?> deleteMovie(@PathVariable("movieId") String movieId) {
        var instance = this.movieService.deleteMovie(movieId);
        if (instance.isPresent()) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
