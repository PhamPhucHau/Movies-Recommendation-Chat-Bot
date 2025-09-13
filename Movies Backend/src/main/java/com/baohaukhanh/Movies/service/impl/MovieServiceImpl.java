package com.baohaukhanh.Movies.service.impl;

import com.baohaukhanh.Movies.dto.MovieDTO;
import com.baohaukhanh.Movies.dto.MovieSummaryDTO;
import com.baohaukhanh.Movies.entity.Movie;
import com.baohaukhanh.Movies.exception.MovieNotFoundException;
import com.baohaukhanh.Movies.mapper.MovieMapper;
import com.baohaukhanh.Movies.repository.MovieRepository;
import com.baohaukhanh.Movies.service.MovieService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MovieServiceImpl implements MovieService {
    
    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    
    @Override
    public List<MovieSummaryDTO> getAllMovies() {
        log.info("Fetching all movies");
        List<Movie> movies = movieRepository.findAllMovies();
        return movieMapper.toMovieSummaryDTOList(movies);
    }
    
    @Override
    public MovieDTO getMovieById(Long id) {
        log.info("Fetching movie with id: {}", id);
        Movie movie = movieRepository.findMovieWithRelationsById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
        return movieMapper.toMovieDTO(movie);
    }
    
    @Override
    public List<MovieSummaryDTO> searchMoviesByTitle(String title) {
        log.info("Searching movies with title containing: {}", title);
        List<Movie> movies = movieRepository.findByTitleContaining(title);
        return movieMapper.toMovieSummaryDTOList(movies);
    }
}
