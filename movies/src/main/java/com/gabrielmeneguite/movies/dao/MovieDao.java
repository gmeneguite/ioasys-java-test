package com.gabrielmeneguite.movies.dao;

import com.gabrielmeneguite.movies.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

@Repository
public interface MovieDao extends PagingAndSortingRepository<Movie, Integer> {
    List<Movie> findMovieByNameContainingOrGenreOrDirectorOrActorsInIgnoreCase(String name, String genre, String director, List<String > actors, Pageable page);
}
