package api.controllers;

import api.data.MovieDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    MovieDao movieDao;

    public AppController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }
}
