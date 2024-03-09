package com.sistersLab.movieFriend.controller;

import com.sistersLab.movieFriend.dto.MovieDto;

import com.sistersLab.movieFriend.service.MovieService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor
@Getter
@Setter
public class MovieController {
    private final MovieService movieService;


    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto) {
        MovieDto createdMovieDto = movieService.createMovie(movieDto);
        return new ResponseEntity<>(createdMovieDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        List<MovieDto> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    // Tek bir filmi ID'ye göre görüntüleme
    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable Long id) {
        MovieDto movieDto = movieService.getMovieById(id);
        return ResponseEntity.ok(movieDto);
    }

    // Film silme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        MovieDto updatedMovieDto = movieService.updateMovie(id, movieDto);
        return ResponseEntity.ok(updatedMovieDto);
    }

    @PatchMapping("/{id}/rate")
    public ResponseEntity<Void> rateMovie(@PathVariable Long id, @RequestParam("rating") double rating) {
        movieService.rateMovie(id, rating);
        return ResponseEntity.ok().build();
    }
}



