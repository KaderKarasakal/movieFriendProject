package com.sistersLab.movieFriend.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MovieDto {
    private Long id;
    private String title;
    private int releaseYear;
    private double rating;
    private String description;
    private String director;
}
