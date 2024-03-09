package com.sistersLab.movieFriend.repository;

import com.sistersLab.movieFriend.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {


}
