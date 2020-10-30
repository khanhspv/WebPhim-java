package com.project.movie.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;


@Document(collection = "users")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @Id
    private String id;
    @Indexed(unique = true)
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDateTime birthDay;
    private LocalDateTime create_At;
    private LocalDateTime modify_At;
    @Indexed(unique = true)
    private String email;
    private String phone;
    private Member member;
    private List<String> role;
    private List<Video> saved_video;
}