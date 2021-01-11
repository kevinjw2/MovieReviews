package api.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoDB {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MovieDaoDB(JdbcTemplate jdbc) { this.jdbcTemplate = jdbc; }


}
