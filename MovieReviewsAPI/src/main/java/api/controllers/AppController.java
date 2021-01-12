package api.controllers;

import api.data.MovieDao;
import api.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    MovieDao movieDao;

    public AppController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GetMapping("/movie")
    public List<Movie> allMovies() {
        return movieDao.getAllMovies();
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<Movie> getByMovieTitle(@PathVariable String title) {
        Movie result = movieDao.getMovieByTitle(title);
        if(result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/movie/{duration}")
    public List<Movie> getMoviesByDuration(@PathVariable int duration) {
        return movieDao.getMoviesByDuration(duration);
    }

    @PostMapping("/new")
    public Movie create(Movie movie) {
        return movieDao.addMovie(movie);
    }
}
