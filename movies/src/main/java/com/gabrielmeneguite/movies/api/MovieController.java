package com.gabrielmeneguite.movies.api;

import com.gabrielmeneguite.movies.dao.MovieDao;
import com.gabrielmeneguite.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "movie")
public class MovieController {
    private MovieDao movieDao;

    @Autowired
    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @PostMapping(path = "new_movie")
    public void addMovie(@RequestBody Movie movie) {
        movieDao.save(movie);
    }

    @GetMapping(path = "/list")
    public @ResponseBody Iterable<Movie> getAllMovies(
            @RequestParam(value = "name", required = false, defaultValue = "") String nameParameter,
            @RequestParam(value = "genre", required = false, defaultValue = "") String genreParameter,
            @RequestParam(value = "director", required = false, defaultValue = "") String directorParameter,
            @RequestParam(value = "actors", required = false) List<String> actorsParameter,
            @RequestParam(value = "page") int numPage,
            @RequestParam(value = "qtd_movies", required = false, defaultValue = "5") int qtdMovies) {
        List<String> actors = (actorsParameter == null ? new ArrayList() : actorsParameter);

        List<Movie> movieList = movieDao.findMovieByNameContainingOrGenreOrDirectorOrActorsInIgnoreCase(nameParameter, genreParameter, directorParameter, actors, PageRequest.of(numPage, qtdMovies));
        Set<Movie> movieSet = new HashSet();
        for (Movie x : movieList)
            movieSet.add(x);
        return movieSet;
    }
}
