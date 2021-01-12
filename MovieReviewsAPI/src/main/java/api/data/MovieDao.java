package api.data;

import api.models.Movie;
import api.models.Rating;

import java.util.List;

public interface MovieDao {

    List<Movie> getAllMovies();
    Movie getMovieByTitle(String title);
    List<Movie> getMoviesByDuration(int duration);
    Movie addMovie(Movie movie);
    void deleteMovieById(int movieId);
    Rating addRating(Rating rating);
    List<Rating> getRatingsForMovie(Movie movie);
    void deleteRatingById(int ratingId);

}
