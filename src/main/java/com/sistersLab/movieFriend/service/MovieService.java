package com.sistersLab.movieFriend.service;

import com.sistersLab.movieFriend.dto.MovieDto;

import com.sistersLab.movieFriend.model.Movie;
import com.sistersLab.movieFriend.repository.MovieRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;



    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = dtoToEntity(movieDto);
        movie = movieRepository.save(movie);
        return entityToDto(movie);
    }
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
    public MovieDto getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(this::entityToDto)
                .orElseThrow(() -> new RuntimeException("Movie not found for this id :: " + id));
    }
    private MovieDto entityToDto(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setTitle(movie.getTitle());
        dto.setReleaseYear(movie.getReleaseYear());
        dto.setRating(movie.getRating());
        dto.setDescription(movie.getDescription());
        dto.setDirector(movie.getDirector());


        return dto;
    }

    public void deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found for this id :: " + id));
        movieRepository.delete(movie);
    }

    private Movie dtoToEntity(MovieDto movieDto)  {
        Movie movie = new Movie();
        movie.setTitle(movieDto.getTitle());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setRating(movieDto.getRating());
        movie.setDescription(movieDto.getDescription());
        movie.setDirector(movieDto.getDirector());
        return movie;
    }

    private void updateMovieFromDto(Movie movie, MovieDto movieDto) {
        movie.setTitle(movieDto.getTitle());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setRating(movieDto.getRating());
    }



    public MovieDto updateMovie(Long id, MovieDto movieDto) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
        updateMovieFromDto(movie, movieDto);
        movie = movieRepository.save(movie);
        return entityToDto(movie);
    }





    public void rateMovie(Long id, double rating) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found with id: " + id));
        movie.setRating(rating);
        movieRepository.save(movie);
    }


}








