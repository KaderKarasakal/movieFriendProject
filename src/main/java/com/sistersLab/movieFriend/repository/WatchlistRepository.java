package com.sistersLab.movieFriend.repository;

import com.sistersLab.movieFriend.model.Watchlist;
import org.springframework.data.jpa.repository.JpaRepository;




public interface WatchlistRepository extends JpaRepository <Watchlist, Long> {


}

