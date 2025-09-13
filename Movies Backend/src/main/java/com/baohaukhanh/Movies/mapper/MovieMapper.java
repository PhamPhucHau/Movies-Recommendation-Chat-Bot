package com.baohaukhanh.Movies.mapper;

import com.baohaukhanh.Movies.dto.*;
import com.baohaukhanh.Movies.entity.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MovieMapper {
    
    public MovieSummaryDTO toMovieSummaryDTO(Movie movie) {
        if (movie == null) {
            return null;
        }
        
        return new MovieSummaryDTO(
            movie.getId(),
            movie.getTitle(),
            movie.getYear(),
            movie.getCertificate(),
            movie.getRuntime(),
            movie.getImdbRating(),
            movie.getMetaScore(),
            movie.getPosterLink()
        );
    }
    
    public MovieDTO toMovieDTO(Movie movie) {
        if (movie == null) {
            return null;
        }
        
        return new MovieDTO(
            movie.getId(),
            movie.getTitle(),
            movie.getYear(),
            movie.getCertificate(),
            movie.getRuntime(),
            movie.getImdbRating(),
            movie.getMetaScore(),
            movie.getOverview(),
            movie.getPosterLink(),
            movie.getGross(),
            movie.getVotes(),
            toActorDTOList(movie.getActors()),
            toDirectorDTOList(movie.getDirectors()),
            toGenreDTOList(movie.getGenres())
        );
    }
    
    public List<MovieSummaryDTO> toMovieSummaryDTOList(List<Movie> movies) {
        if (movies == null) {
            return null;
        }
        
        return movies.stream()
                .map(this::toMovieSummaryDTO)
                .collect(Collectors.toList());
    }
    
    public List<MovieDTO> toMovieDTOList(List<Movie> movies) {
        if (movies == null) {
            return null;
        }
        
        return movies.stream()
                .map(this::toMovieDTO)
                .collect(Collectors.toList());
    }
    
    private ActorDTO toActorDTO(Actor actor) {
        if (actor == null) {
            return null;
        }
        
        return new ActorDTO(actor.getId(), actor.getName());
    }
    
    private List<ActorDTO> toActorDTOList(List<Actor> actors) {
        if (actors == null) {
            return null;
        }
        
        return actors.stream()
                .map(this::toActorDTO)
                .collect(Collectors.toList());
    }
    
    private DirectorDTO toDirectorDTO(Director director) {
        if (director == null) {
            return null;
        }
        
        return new DirectorDTO(director.getId(), director.getName());
    }
    
    private List<DirectorDTO> toDirectorDTOList(List<Director> directors) {
        if (directors == null) {
            return null;
        }
        
        return directors.stream()
                .map(this::toDirectorDTO)
                .collect(Collectors.toList());
    }
    
    private GenreDTO toGenreDTO(Genre genre) {
        if (genre == null) {
            return null;
        }
        
        return new GenreDTO(genre.getId(), genre.getName());
    }
    
    private List<GenreDTO> toGenreDTOList(List<Genre> genres) {
        if (genres == null) {
            return null;
        }
        
        return genres.stream()
                .map(this::toGenreDTO)
                .collect(Collectors.toList());
    }
}
