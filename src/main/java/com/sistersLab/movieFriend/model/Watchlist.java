package com.sistersLab.movieFriend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "watchlist")
@Getter
@Setter
@RequiredArgsConstructor
public class Watchlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate addedDate;
    private boolean watchedStatus;
    private LocalDate watchedDate;
    private String notes;



}