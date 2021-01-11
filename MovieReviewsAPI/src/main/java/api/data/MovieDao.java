package api.data;

import api.models.Movie;

import java.util.List;

public interface MovieDao {

    List<Movie> getAllMovies();
    Movie getMovieByTitle(String title);
    List<Movie> getMoviesByDuration(int duration);
    Movie addMovie(Movie movie);
    void updateRating();
    //void calculateAvgRating();

}
