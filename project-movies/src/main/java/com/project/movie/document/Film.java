package com.project.movie.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("film")
public class Film {

    @Id
    private String id;
    private String name;
    private String status;
    private String director;
    private String type;
    private String types;
    private String nation;
    private String quality;
    private String language;
    private Integer time;
    @NonNull
    @Field()
    private LocalDateTime release;
    private String content;
    @NonNull
    private LocalDateTime createAt;
    @NonNull
    private LocalDateTime modifyAt;
    private Boolean statusActive;
    private String url;
    private Integer age;
    private List<Actor> actor;
    private Serie series_movie;
    private List<Esposide> esposide;
    private List<Comment> comment;
}
