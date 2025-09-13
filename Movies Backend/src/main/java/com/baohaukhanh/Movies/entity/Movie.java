package com.baohaukhanh.Movies.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Movie")
public class Movie {
    
    @Id
    @GeneratedValue
    private Long id;
    
    @Property("title")
    private String title;
    
    @Property("year")
    private String year;
    
    @Property("certificate")
    private String certificate;
    
    @Property("runtime")
    private String runtime;
    
    @Property("imdb_rating")
    private String imdbRating;
    
    @Property("meta_score")
    private String metaScore;
    
    @Property("overview")
    private String overview;
    
    @Property("poster_link")
    private String posterLink;
    
    @Property("gross")
    private String gross;
    
    @Property("votes")
    private String votes;
    
    @Relationship(type = "ACTED_BY", direction = Relationship.Direction.OUTGOING)
    private List<Actor> actors;
    
    @Relationship(type = "DIRECTED_BY", direction = Relationship.Direction.OUTGOING)
    private List<Director> directors;
    
    @Relationship(type = "HAS_GENRE", direction = Relationship.Direction.OUTGOING)
    private List<Genre> genres;
}
