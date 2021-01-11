DROP DATABASE IF EXISTS personalMovieRecs;

CREATE DATABASE personalMovieRecs;

USE personalMovieRecs;

CREATE TABLE Movie (
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR(50) NOT NULL,
    Director VARCHAR(30) NOT NULL,
    Duration INT,
    ReleaseYear CHAR(4) NOT NULL,
    LeadActor VARCHAR(30) NULL,
    LeadActress VARCHAR(30) NULL,
    Genre VARCHAR(10) NOT NULL
);

CREATE TABLE Rating (
	PersonalRating INT,
    PersonalComments VARCHAR(500) NULL,
    MovieId INT,
    FOREIGN KEY fk_Movie_Rating (MovieId)
		REFERENCES Movie(Id)
);

