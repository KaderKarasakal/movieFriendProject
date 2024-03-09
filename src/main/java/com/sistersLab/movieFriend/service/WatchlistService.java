package com.sistersLab.movieFriend.service;

import com.sistersLab.movieFriend.dto.MovieDto;
import com.sistersLab.movieFriend.model.Cinephile;
import com.sistersLab.movieFriend.model.Movie;

import com.sistersLab.movieFriend.model.Watchlist;
import com.sistersLab.movieFriend.repository.CinephileRepository;
import com.sistersLab.movieFriend.repository.MovieRepository;


import com.sistersLab.movieFriend.repository.WatchlistRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import org.springframework.stereotype.Service;

import java.util.List;


import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Getter
@Setter
public class WatchlistService  {
    private final CinephileRepository cinephileRepository;
    private final MovieRepository movieRepository;
    private final WatchlistRepository watchlistRepository;



    public void addMovieToCinephileWatchlist(Long cinephileId, Long movieId) {
        Cinephile cinephile = cinephileRepository.findById(cinephileId)
                .orElseThrow(() -> new RuntimeException("Cinephile not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        cinephile.getMovies().add(movie);
        movie.getCinephiles().add(cinephile);
        cinephileRepository.save(cinephile);
    }


    public void removeMovieFromCinephileWatchlist(Long cinephileId, Long movieId) {
        Cinephile cinephile = cinephileRepository.findById(cinephileId)
                .orElseThrow(() -> new RuntimeException("Cinephile not found"));
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        cinephile.getMovies().remove(movie);
        movie.getCinephiles().remove(cinephile);
        cinephileRepository.save(cinephile);
    }




    private MovieDto convertToDto(Movie movie) {
        MovieDto movieDto = new MovieDto();
        movieDto.setId(movie.getId());
        movieDto.setTitle(movie.getTitle());
        movieDto.setReleaseYear(movie.getReleaseYear());
        movieDto.setRating(movie.getRating());
        movieDto.setDescription(movie.getDescription());
        movieDto.setDirector(movie.getDirector());
        return movieDto;
    }


    public List<MovieDto> getCinephileMovies(Long cinephileId) {

            Cinephile cinephile = cinephileRepository.findById(cinephileId)
                    .orElseThrow(() -> new EntityNotFoundException("Cinephile not found with id: " + cinephileId));

            return cinephile.getMovies().stream()
                    .map(this::convertToMovieDto)
                    .collect(Collectors.toList());
        }

        private MovieDto convertToMovieDto(Movie movie) {
            MovieDto movieDto = new MovieDto();
            movieDto.setId(movie.getId());
            movieDto.setTitle(movie.getTitle());
            movieDto.setReleaseYear(movie.getReleaseYear());
            movieDto.setRating(movie.getRating());
            movieDto.setDescription(movie.getDescription());
            movieDto.setDirector(movie.getDirector());
            // Diğer alanlarınız varsa ekleyin.
            return movieDto;
        }



}









