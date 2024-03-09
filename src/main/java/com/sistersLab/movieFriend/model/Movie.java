package com.sistersLab.movieFriend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movie")
@RequiredArgsConstructor
@Getter
@Setter
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String director;
    private int releaseYear;
    private double rating;

    @ManyToMany(mappedBy = "movies", cascade = CascadeType.ALL)
    private Set<Cinephile> cinephiles = new HashSet<>();


}
