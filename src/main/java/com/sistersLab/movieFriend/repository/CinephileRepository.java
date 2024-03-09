package com.sistersLab.movieFriend.repository;

import com.sistersLab.movieFriend.model.Cinephile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinephileRepository extends JpaRepository<Cinephile, Long> {
}
