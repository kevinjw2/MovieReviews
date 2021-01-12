package api.models;

public class Rating {

    private int ratingId;
    private int personalRating;
    private String personalComments;
    private int movieId;

    public int getRatingId() {
        return ratingId;
    }

    public void setRatingId(int ratingId) {
        this.ratingId = ratingId;
    }

    public int getPersonalRating() {
        return personalRating;
    }

    public void setPersonalRating(int personalRating) {
        this.personalRating = personalRating;
    }

    public String getPersonalComments() {
        return personalComments;
    }

    public void setPersonalComments(String personalComments) {
        this.personalComments = personalComments;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
