package com.sistersLab.movieFriend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "cinephiles")
@Getter
@Setter
@RequiredArgsConstructor
public class Cinephile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;

    @ManyToMany()
    @JoinTable(name = "cinephile_movie",
            joinColumns = @JoinColumn(name = "cinephile_id",referencedColumnName = "id"),

            inverseJoinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "id")
    )
    private Set<Movie> movies = new HashSet<>();


}
