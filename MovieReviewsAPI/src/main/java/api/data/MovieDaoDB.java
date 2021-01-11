package api.data;

import api.models.Movie;
import api.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class MovieDaoDB implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDaoDB(JdbcTemplate jdbc) { this.jdbcTemplate = jdbc; }

    @Override
    public List<Movie> getAllMovies() {
        final String sql = "SELECT * FROM movie;";
        return jdbcTemplate.query(sql, new MovieMapper());
    }

    @Override
    public Movie getMovieByTitle(String title) {
        final String sql = "SELECT * FROM movie WHERE Title = ?;";
        return jdbcTemplate.queryForObject(sql, new MovieMapper(), title);
    }

    @Override
    public List<Movie> getMoviesByDuration(int duration) {
        final String sql = "SELECT * FROM movie WHERE Duration <= ?;";
        return jdbcTemplate.query(sql, new MovieMapper(), duration);
    }

    @Override
    public Movie addMovie(Movie movie) {
        final String sql = "INSERT INTO Movie(, inProgress) VALUES(?,?);";
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update((Connection conn) -> {
            PreparedStatement statement = conn.prepareStatement(
                    sql,
                    Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getDirector());
            statement.setInt(3, movie.getDuration());
            statement.setDate(4, movie.getReleaseDate());
            statement.setString(5, movie.getLeadActor());
            statement.setString(6, movie.getLeadActress());
            statement.setString(7, movie.getGenre());
            return statement;
        }, keyHolder);
        movie.setMovieId(keyHolder.getKey().intValue());
        return movie;
    }

    public static final class MovieMapper implements RowMapper<Movie> {

        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            Movie movie = new Movie();
            movie.setMovieId(rs.getInt("Id"));
            movie.setTitle(rs.getString("Title"));
            movie.setDirector(rs.getString("Director"));
            movie.setDuration(rs.getInt("Duration"));
            movie.setReleaseDate(rs.getDate("ReleaseDate"));
            movie.setLeadActor(rs.getString("LeadActor"));
            movie.setLeadActress(rs.getString("LeadActress"));
            movie.setGenre(rs.getString("Genre"));
            return movie;
        }
    }

    private static final class RatingMapper implements RowMapper<Rating> {

        @Override
        public Rating mapRow(ResultSet rs, int index) throws SQLException {
            Rating rating = new Rating();
            rating.setPersonalRating(rs.getInt("PersonalRating"));
            rating.setPersonalComments(rs.getString("PersonalComments"));
            rating.setMovieId(rs.getInt("MovieId"));
            return rating;
        }
    }
}
