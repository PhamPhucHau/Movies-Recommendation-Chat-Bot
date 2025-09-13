package com.baohaukhanh.Movies.repository;

import com.baohaukhanh.Movies.entity.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
    
    @Query("MATCH (m:Movie) RETURN m ORDER BY m.title")
    List<Movie> findAllMovies();
    
    @Query("MATCH (m:Movie) WHERE id(m) = $id " +
           "OPTIONAL MATCH (m)-[:ACTED_BY]->(a:Actor) " +
           "OPTIONAL MATCH (m)-[:DIRECTED_BY]->(d:Director) " +
           "OPTIONAL MATCH (m)-[:HAS_GENRE]->(g:Genre) " +
           "RETURN m, collect(DISTINCT a) as actors, collect(DISTINCT d) as directors, collect(DISTINCT g) as genres")
    Optional<Movie> findMovieWithRelationsById(@Param("id") Long id);
    
    @Query("MATCH (m:Movie) WHERE m.title CONTAINS $title RETURN m ORDER BY m.title")
    List<Movie> findByTitleContaining(@Param("title") String title);
}
