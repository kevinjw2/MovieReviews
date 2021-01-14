DROP DATABASE IF EXISTS personalMovieRecs;

CREATE DATABASE personalMovieRecs;

USE personalMovieRecs;

CREATE TABLE Movie (
    MovieId INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(100) NOT NULL,
    Director VARCHAR(30),
    Duration INT,
    ReleaseYear CHAR(4) NOT NULL,
    LeadActor VARCHAR(30) NULL,
    LeadActress VARCHAR(30) NULL,
    Genre VARCHAR(20)
);

CREATE TABLE Rating (
    RatingId INT PRIMARY KEY AUTO_INCREMENT,
    PersonalRating INT,
    PersonalComments VARCHAR(500) NULL,
    MovieId INT,
    FOREIGN KEY fk_Movie_Rating (MovieId)
		REFERENCES Movie(MovieId)
);

