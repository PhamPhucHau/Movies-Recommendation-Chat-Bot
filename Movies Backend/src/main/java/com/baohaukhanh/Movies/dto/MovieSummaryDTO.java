package com.baohaukhanh.Movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieSummaryDTO {
    
    private Long id;
    private String title;
    private String year;
    private String certificate;
    private String runtime;
    private String imdbRating;
    private String metaScore;
    private String posterLink;
}
