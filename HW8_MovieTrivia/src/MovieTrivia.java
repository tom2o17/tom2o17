// I, Thomas Clement #21828132, worked alone on this assignment.


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
	
	
	// List of 5 utility methods that we are requested to write
	
	
	public void insertActor (String actor, String [] movies, ArrayList <Actor> actorsInfo) {
		/*
		 * This function inserts a given actor <string> and a list of strings which represent movies they were cast in 
		 * into the 'actorsInfo' array
		 * 
		 * This function returns nothing 
		 */
		
		// the input actor is cast to lower case and trimmed per format 
		actor = actor.toLowerCase().trim();
		// This loop iterates over the list of movies handed to the function and casts them to lower case and trims them 
		for (int k = 0; k < movies.length; k++) {
			movies[k] = movies[k].toLowerCase().trim();
		}
		// This loop checks to see if our actor is already in the array
		for (int i = 0; i < actorsInfo.size(); i++) {
			// if our actor is already in the array
			if (actorsInfo.get(i).getName().equals(actor)) {
				// loops through the list of movies handed to the fucntion 
				for (int k = 0; k < movies.length; k++) {
					// if the movie is already in the database the function does nothing 
					if (actorsInfo.get(i).getMoviesCast().contains(movies[k])) {
					// Else if the movie is not already in the database the function appends that movie to the database 	
					} else {
					actorsInfo.get(i).getMoviesCast().add(movies[k]);
					}};
			} 
			// Else if our actor was not in the data base his information and movies are appended to the database 
			else if (i == actorsInfo.size()-1) {
				Actor actor1 = new Actor(actor);
				actorsInfo.add(actor1);
				for (String movie: movies) {
					actor1.getMoviesCast().add(movie);
				};
			}
			}
		
	}
	
	
	public void insertRating (String movie, int [] ratings, ArrayList <Movie> moviesInfo) {
		/* This function takes a movie given as string and a list of strings which represents the ratings for the movies 
		 * as well as the Arraylist actorsInfo and:
		 * 
		 * checks to see if they are already present in our database.
		 * 
		 *  if the movie is present in the database the function will update the ratings to reflect the ratings list handed to the 
		 *  function 
		 * 
		 * else if the movie is not present then the function will create a new instance of Movie and will append that to the 
		 * database 
		 * 
		 */
		
		// This block of code checks to ensure that our rating is within the acceptable bounds of a valid rating 
		movie = movie.toLowerCase().trim();
		for (int i = 0; i < ratings.length; i++ ) {
			if (ratings[i] > 100 || ratings[i] < 0 ) {
				return;
			}
		}
		// performs the function mentioned in the function doc ^^
		for ( int i = 0; i < moviesInfo.size(); i++) {
			// Check to see if our movie is already present in the database 
			if (moviesInfo.get(i).getName().equals(movie)) {
				moviesInfo.get(i).setAudienceRating(ratings[1]);
				moviesInfo.get(i).setCriticRating(ratings[0]);
			}
			else if (i == moviesInfo.size() -1) {
				Movie movie1 = new Movie(movie, ratings[0], ratings[1]);
				moviesInfo.add(movie1);
			}	
		}	
	}
	
	
	public ArrayList <String> selectWhereActorIs(String actor, ArrayList <Actor> actosInfo) {
		/*
		 * This function takes an actor represented by a sting as well as the Arraylist actorsInfo
		 * 
		 * The function then loops through the actors in the actorsInfo array and checks to see if any actors name matches
		 * the actor handed to the function 
		 * 
		 * if the above condition is true these values are appended to a list initialized by the function and then returned. 
		 */
		actor = actor.toLowerCase().trim();
		ArrayList<String> list = new ArrayList<String>();
		for ( int i = 0; i < actorsInfo.size(); i ++) {
			if (actorsInfo.get(i).getName().equals(actor)) {
				list = actorsInfo.get(i).getMoviesCast();
			}}
		return list;
	}
	
	
	public ArrayList <String> selectWhereMovieIs (String movie, ArrayList <Actor> actorsInfo) {
		/*
		 * This function takes the inputs of movie <string> and an Arraylist . 
		 * 
		 *  The function then checks to see if the movie is present in any of the actors contained in the
		 *  Arraylist passed to the function
		 *   
		 *  if a given actors list of movies contains the movie massed to the function that name 
		 *  is appended to a list which is iniitalized inside of the function and then retruned 
		 *    
		 */
		movie = movie.toLowerCase().trim();
		ArrayList<String> list = new ArrayList<String>();
		for ( int i = 0; i < actorsInfo.size(); i++) {
			if (actorsInfo.get(i).getMoviesCast().contains(movie)) {
				list.add(actorsInfo.get(i).getName());
			}}
		return list; 
		
	}
	
	
	
	
	public ArrayList <String> selectWhereRatingIs (char comparison, int targetRating, boolean isCritic,
			ArrayList <Movie> moviesInfo) {
		/*
		 * This function takes an comparison <char>,  target rating <int>, and isCritic <boolean> variables 
		 * 
		 * and returns a list of movies that satisfy the param passed to the function 
		 */
		
		// Flow control variable 
		boolean flow = true;
		
		// This block checks to ensure that the target rating passed to the function is a valid rating 
		if (targetRating > 100 | targetRating < 0) {
			// changes the flow variable so the function does not enter any of the following if statements 
			flow = false;
		}
		// initializes a list which will be returned by the function 
		ArrayList<String> list = new ArrayList<String>();
		
		
		// loop will enter different parts of this block depending on the param handed to the function 
		// if it enters a given portion it will perform the logical operation handed to the function and add 
		// all of the movies that fulfill that requirement to the initialized list 
		for (int i = 0; i < moviesInfo.size(); i++) {
			if (comparison == '>' && flow) {
				if (isCritic == true) {
					if(moviesInfo.get(i).getCriticRating() > targetRating) {
						list.add(moviesInfo.get(i).getName());
					}
				} else if (isCritic == false) {
					if(moviesInfo.get(i).getAudienceRating() > targetRating) {
						list.add(moviesInfo.get(i).getName());
					}}
				
				
			} else if (comparison == '=' && flow) {
				if (isCritic == true) {
					if(moviesInfo.get(i).getCriticRating() == targetRating) {
						list.add(moviesInfo.get(i).getName());
					}
				} else if (isCritic == false) {
					if(moviesInfo.get(i).getAudienceRating() == targetRating) {
						list.add(moviesInfo.get(i).getName());
					}}
				
				
			} else if (comparison == '<' && flow) {
				if (isCritic == true) {
					if(moviesInfo.get(i).getCriticRating() < targetRating) {
						list.add(moviesInfo.get(i).getName());
					}
				} else if (isCritic == false) {
					if(moviesInfo.get(i).getAudienceRating() < targetRating) {
						list.add(moviesInfo.get(i).getName());
					}}}	
			}
		return list;
		}
	
	
	
	public ArrayList <String> getCoActors(String actor, ArrayList <Actor> actorsInfo){
		/*
		 * This function takes an actors name and the arraylist actorsInfo as a parameter 
		 * 
		 * Then calls the 'selectWhereActorIs()' function in order to get the list of movies where the actor was cast
		 * 
		 * the function then iterates over the size of the list of movies returned from the 
		 * 'selectWhereActorIs()' function and appends them to a newly initialized list 
		 * 
		 *  A while loop is entered that removes the actors name from the list returned from the 
		 *  previous for loop 
		 */
		ArrayList<String> actors = new ArrayList<String>();
		actor = actor.toLowerCase().trim();
		ArrayList<String> moviesCast = selectWhereActorIs(actor, actorsInfo);
		for ( int i = 0; i < moviesCast.size(); i++) {
			actors.addAll(selectWhereMovieIs(moviesCast.get(i), actorsInfo));
			}
		
		while (actors.contains(actor)) {
			actors.remove(actor);
		}
		return actors; 
		
		}
		
		
	
	
		public ArrayList <String> getCommonMovie(String actor1, String actor2, ArrayList<Actor> actorsInfo) {
			/*
			 * This function takes two actors names as input then uses the 'selectWhereActorIs()' function to get a list
			 * movies for each actor.
			 * 
			 * The function then checks to see if any of these movies are equivelant to one another. 
			 * 
			 * If they are: 
			 * this movie is added to a list that is initialized within the fucntion and will return that list 
			 */
			actor1 = actor1.toLowerCase().trim();
			actor2 = actor2.toLowerCase().trim();
		
			ArrayList<String> movies = new ArrayList<String>();
			ArrayList<String> movies1 = selectWhereActorIs(actor1, actorsInfo);
			ArrayList<String> movies2 = selectWhereActorIs(actor2, actorsInfo);
			for (int i = 0; i < movies1.size(); i++) {
				for (int j = 0; j < movies2.size(); j++) {
					
					if(movies1.get(i).equals(movies2.get(j))) {
						movies.add(movies1.get(i));
					}}}
			return movies;
		}
	
		
		public ArrayList<String> goodMovies(ArrayList<Movie> moviesInfo){
			/*
			 * This function takes one parameter which is the array list goodmovies 
			 * 
			 * The 'selectWhereRatingIs()' function is then called so that the requirements for the function are satisfied 
			 *
			 * The function then checks to see if movies contained in the lists returned from the call to selectWhereRatingIs()
			 * are present in both lists 
			 * 
			 *  If a given movie is present in both lists then that movie is appended to a list that is initialized 
			 *  in the function, this is the list returned by the function 
			 *  
			 *  returns movies >= 85 for both critic rating and audience rating 
			 * 
			 */
			ArrayList<String> goodMovies = new ArrayList<String>();
			ArrayList<String> goodCrit = selectWhereRatingIs('>', 85, true, moviesInfo);
			ArrayList<String> goodAud = selectWhereRatingIs('>', 85, false, moviesInfo);
			
			
			ArrayList<String> gc85 = selectWhereRatingIs('=', 85, true, moviesInfo);
			ArrayList<String> ga85 = selectWhereRatingIs('=', 85, false, moviesInfo);
			goodCrit.addAll(gc85);
			goodAud.addAll(ga85);
			
			
			for (int i = 0; i < goodCrit.size(); i++) {
				for(int j = 0; j < goodAud.size(); j++) {
					if (goodCrit.get(i).equals(goodAud.get(j))) {
						goodMovies.add(goodCrit.get(i));
					}}}
			return goodMovies;	
			}


		public ArrayList<String> getCommonActors (String movie1, String movie2, ArrayList<Actor> actorsInfo){
			/*
			 * This function takes two movie names as inputs and returns the list of actoras that are present 
			 * both movies 
			 * 
			 * The movie names are handed to the 'selectWhereMovieIs()' function and the returns are each stored 
			 * in a different lists 
			 * 
			 * The function then checks to see if any of the entries in each list are present in the other 
			 * 
			 * If they are: the actors name is appended to a list which is initialized within the function 
			 * 
			 * The function then returns this list 
			 */
			ArrayList<String> common = new ArrayList<String>();
			movie1 = movie1.toLowerCase().trim();
			movie2 = movie2.toLowerCase().trim();
			ArrayList<String> act1 = selectWhereMovieIs(movie1, actorsInfo);
			ArrayList<String> act2 = selectWhereMovieIs(movie2, actorsInfo);
			for (int i = 0; i < act1.size(); i++) {
				for(int j = 0; j < act2.size(); j++) {
					if(act1.get(i).equals(act2.get(j))) {
						common.add(act1.get(i));
					}}}
			return common;
		}

		
		public static double [] getMean(ArrayList <Movie> moviesInfo) {
			/*
			 * This function when called will return a list of double in which the index 0 entry is the 
			 * average of the critics rating for all movies and the other entry at index position 1 is the average 
			 * audience ratings for all movies in the moviesInfo Arraylist 
			 */
			
			
			double crit_total = 0;
			double aud_total = 0;
			for ( int i = 0; i < moviesInfo.size(); i++) {
				crit_total = crit_total + moviesInfo.get(i).getCriticRating();
			}
			for (int j = 0; j < moviesInfo.size(); j++) {
				aud_total = aud_total + moviesInfo.get(j).getAudienceRating();
			}
			double x = moviesInfo.size();
			
			double aud_avg = aud_total/x;
			double crit_avg = crit_total/x;
			double [] list = new double[] {crit_avg, aud_avg};
			
			return list;
		}
}
	
	





	
	