package ru.bmstu.iu7.topmovies.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.bmstu.iu7.topmovies.backend.domain.Movie;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Page<Movie> findMovies(Pageable page);
}
