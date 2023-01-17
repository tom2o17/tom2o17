package HW8_MovieTrivia.src;

import java.util.ArrayList;

import file.MovieDB;
import movies.Actor;
import movies.Movie;

/**
 * Movie trivia class providing different methods for querying and updating a movie database.
 */
public class MovieTrivia {
	
	/**
	 * List of actors information.
	 */
	public ArrayList<Actor> actorsInfo = new ArrayList<Actor>();
	
	/**
	 * List of movies information.
	 */
	public ArrayList<Movie> moviesInfo = new ArrayList<Movie>();
	
	
	public static void main(String[] args) {
		
		//create instance of movie trivia class
		MovieTrivia mt = new MovieTrivia();
		
		//setup movie trivia class
		mt.setUp("moviedata.txt", "movieratings.csv");
	}
	
	public void setUp(String movieData, String movieRatings) {
		//create instance of movie database
		MovieDB movieDB = new MovieDB();
		
		//load movie database files
		movieDB.setUp(movieData, movieRatings);
		
		//get actor and movie data
		this.actorsInfo = movieDB.getActorsInfo();
		this.moviesInfo = movieDB.getMoviesInfo();
		
		//print all actors and movies
		this.printAllActors();
		this.printAllMovies();		
	}
	
	public void printAllActors () {
		System.out.println(actorsInfo);
	}
	
	public void printAllMovies () {
		System.out.println(moviesInfo);
	}
	
}
