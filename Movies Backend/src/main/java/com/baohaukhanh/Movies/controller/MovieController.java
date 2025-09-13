package com.baohaukhanh.Movies.controller;

import com.baohaukhanh.Movies.dto.MovieDTO;
import com.baohaukhanh.Movies.dto.MovieSummaryDTO;
import com.baohaukhanh.Movies.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Movies", description = "API endpoints for managing movies")
public class MovieController {
    
    private final MovieService movieService;
    
    @GetMapping
    @Operation(summary = "Get all movies", description = "Retrieve a list of all movies with basic information")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved movies"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<MovieSummaryDTO>> getAllMovies() {
        log.info("Received request to get all movies");
        List<MovieSummaryDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }
    
    @GetMapping("/{id}")
    @Operation(summary = "Get movie by ID", description = "Retrieve detailed information about a specific movie")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved movie details"),
        @ApiResponse(responseCode = "404", description = "Movie not found"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<MovieDTO> getMovieById(
            @Parameter(description = "Movie ID", required = true)
            @PathVariable Long id) {
        log.info("Received request to get movie with id: {}", id);
        MovieDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }
    
    @GetMapping("/search")
    @Operation(summary = "Search movies by title", description = "Search for movies by title containing the given keyword")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully retrieved search results"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<List<MovieSummaryDTO>> searchMoviesByTitle(
            @Parameter(description = "Title keyword to search for", required = true)
            @RequestParam String title) {
        log.info("Received request to search movies with title: {}", title);
        List<MovieSummaryDTO> movies = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }
}
