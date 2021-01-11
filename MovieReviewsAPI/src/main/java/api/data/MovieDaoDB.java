package api.data;

import api.models.Movie;
import api.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class MovieDaoDB {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDaoDB(JdbcTemplate jdbc) { this.jdbcTemplate = jdbc; }



    public static final class movieMapper implements RowMapper<Movie> {
        
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();
            movie.setMovieId(rs.getInt("movieId"));
            movie.setTitle(rs.getString("title"));
            movie.setDirector(rs.getString("director"));
            movie.setDuration(rs.getInt("duration"));
            movie.setReleaseDate(rs.getDate("releaseDate"));
            movie.setLeadActor(rs.getString("leadActor"));
            movie.setLeadActress(rs.getString("leadActress"));
            movie.setGenre(rs.getString("genre"));
            return movie;
        }
    }

    private static final class RatingMapper implements RowMapper<Rating> {

        @Override
        public Rating mapRow(ResultSet rs, int index) throws SQLException {
            Rating rating = new Rating();
            rating.setPersonalRating(rs.getInt("personalRating"));
            rating.setPersonalComments(rs.getString("personalComments"));
            rating.setMovieId(rs.getInt("movieId"));
            return rating;
        }
    }
}
