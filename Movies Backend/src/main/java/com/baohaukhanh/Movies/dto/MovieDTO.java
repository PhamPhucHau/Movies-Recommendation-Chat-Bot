package com.baohaukhanh.Movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    
    private Long id;
    private String title;
    private String year;
    private String certificate;
    private String runtime;
    private String imdbRating;
    private String metaScore;
    private String overview;
    private String posterLink;
    private String gross;
    private String votes;
    private List<ActorDTO> actors;
    private List<DirectorDTO> directors;
    private List<GenreDTO> genres;
}
