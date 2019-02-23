package ru.bmstu.iu7.topmovies.backend.domain;

import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@NoArgsConstructor
@Accessors(chain = true)
@Document(collection = "movies")
public class Movie {
    @Id
    private String id;

    @Field("title")
    private String title;

    @Field("year")
    private Integer year;

    @Field("genre")
    private String genre;

    @Field("director")
    private String director;

    @Field("actors")
    private List<String> actors;

    @Field("rating")
    private Float rating;

    @Field("description")
    private String description;
}
