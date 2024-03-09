package com.sistersLab.movieFriend.controller;

import com.sistersLab.movieFriend.dto.MovieDto;
import com.sistersLab.movieFriend.service.WatchlistService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/watchlist")
@Getter
@Setter
@RequiredArgsConstructor
public class WatchlistController {
    private final WatchlistService watchlistService;
    @GetMapping("/{cinephileId}/movies")
    public ResponseEntity<List<MovieDto>> getCinephileMovies(@PathVariable Long cinephileId) {
        List<MovieDto> movies = watchlistService.getCinephileMovies(cinephileId);
        return ResponseEntity.ok(movies);
    }


    @PostMapping("/{cinephileId}/add/{movieId}")
    public ResponseEntity<String> addMovieToWatchlist(@PathVariable Long cinephileId, @PathVariable Long movieId) {
        watchlistService.addMovieToCinephileWatchlist(cinephileId, movieId);
        return ResponseEntity.ok("Movie added to watchlist successfully.");
    }

    //

    @DeleteMapping("/{cinephileId}/remove/{movieId}")
    public ResponseEntity<String> removeMovieFromWatchlist(@PathVariable Long cinephileId, @PathVariable Long movieId) {
        watchlistService.removeMovieFromCinephileWatchlist(cinephileId, movieId);
        return ResponseEntity.ok("Movie removed from watchlist successfully.");
    }






}
