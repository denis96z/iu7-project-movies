package ru.bmstu.iu7.topmovies.backend.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "movies")
public class   Movie {
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
    private Movie obj;

    public Movie() {
    }

    @Override
    public int hashCode() {
        var hash = 0;
        for (var i = 0; i < this.id.length(); i++) {
            var character = this.id.charAt(i);
            hash = ((hash<<5)-hash)+character;
            hash = hash & hash; // Convert to 32bit integer
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return this.hashCode() ==obj.hashCode();
    }

   // @Override
    //public boolean equals(Movie obj) {
    //    this.obj = obj;
    //    return this.id.equals(obj.id);
    //}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
