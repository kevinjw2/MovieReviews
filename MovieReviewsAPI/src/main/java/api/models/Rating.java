package api.models;

public class Rating {

    private int personalRating;
    private String personalComments;
    private int movieId;

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
