package HW8_MovieTrivia.src;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import file.MovieDB;


class MovieTriviaTest {
	
	//instance of movie trivia object to test
	MovieTrivia mt;
	
	@BeforeEach
	void setUp() throws Exception {
		//initialize movie trivia object
		mt = new MovieTrivia ();
		
		//set up movie trivia object
		mt.setUp("moviedata.txt", "movieratings.csv");
	}

	@Test
	void testSetUp() { 
		assertEquals(mt.actorsInfo.size(), 6);
		assertEquals(mt.moviesInfo.size(), 7);
		
		assertEquals(mt.actorsInfo.get(0).getName(), "meryl streep");
		assertEquals(mt.actorsInfo.get(0).getMoviesCast().size(), 3);
		assertEquals(mt.actorsInfo.get(0).getMoviesCast().get(0), "doubt");
		
		assertEquals(mt.moviesInfo.get(0).getName(), "doubt");
		assertEquals(mt.moviesInfo.get(0).getCriticRating(), 79);
		assertEquals(mt.moviesInfo.get(0).getAudienceRating(), 78);
	}
	
	@Test
	void testInsertActor () {
		mt.insertActor("test1", new String [] {"testmovie1", "testmovie2"}, mt.actorsInfo);
		assertEquals(mt.actorsInfo.size(), 7);	
		assertEquals(mt.actorsInfo.get(mt.actorsInfo.size() - 1).getName(), "test1");
		assertEquals(mt.actorsInfo.get(mt.actorsInfo.size() - 1).getMoviesCast().size(), 2);
		assertEquals(mt.actorsInfo.get(mt.actorsInfo.size() - 1).getMoviesCast().get(0), "testmovie1");
		
		// TODO add additional test case scenarios
		
	}
	
	@Test
	void testInsertRating () {
		mt.insertRating("testmovie", new int [] {79, 80}, mt.moviesInfo);
		assertEquals(mt.moviesInfo.size(), 8);	
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getName(), "testmovie");
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getCriticRating(), 79);
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getAudienceRating(), 80);
		
		// TODO add additional test case scenarios
	}
	
	@Test
	void testSelectWhereActorIs () {
		assertEquals(mt.selectWhereActorIs("meryl streep", mt.actorsInfo).size(), 3);
		assertEquals(mt.selectWhereActorIs("meryl streep", mt.actorsInfo).get(0), "doubt");
		
		// TODO add additional test case scenarios
	}
	
	@Test
	void testSelectWhereMovieIs () {
		assertEquals(mt.selectWhereMovieIs("doubt", mt.actorsInfo).size(), 2);
		assertEquals(mt.selectWhereMovieIs("doubt", mt.actorsInfo).contains("meryl streep"), true);
		assertEquals(mt.selectWhereMovieIs("doubt", mt.actorsInfo).contains("amy adams"), true);
		
		// TODO add additional test case scenarios
	}
	
	@Test
	void testSelectWhereRatingIs () {
		assertEquals(mt.selectWhereRatingIs('>', 0, true, mt.moviesInfo).size(), 6);
		assertEquals(mt.selectWhereRatingIs('=', 65, false, mt.moviesInfo).size(), 0);
		assertEquals(mt.selectWhereRatingIs('<', 30, true, mt.moviesInfo).size(), 2);
		
		// TODO add additional test case scenarios
	}
	
	@Test
	void testGetCoActors () {
		assertEquals(mt.getCoActors("meryl streep", mt.actorsInfo).size(), 2);
		assertTrue(mt.getCoActors("meryl streep", mt.actorsInfo).contains("tom hanks"));
		assertTrue(mt.getCoActors("meryl streep", mt.actorsInfo).contains("amy adams"));
		
		// TODO add additional test case scenarios
	}
	
	@Test
	void testGetCommonMovie () {
		assertEquals(mt.getCommonMovie("meryl streep", "tom hanks", mt.actorsInfo).size(), 1);
		assertTrue(mt.getCommonMovie("meryl streep", "tom hanks", mt.actorsInfo).contains("the post"));
		
		// TODO add additional test case scenarios
	}
	
	@Test
	void testGoodMovies () {
		assertEquals(mt.goodMovies(mt.moviesInfo).size(), 3);
		assertTrue(mt.goodMovies(mt.moviesInfo).contains("jaws"));
	
		// TODO add additional test case scenarios
	}
	
	@Test
	void testGetCommonActors () {
		assertEquals(mt.getCommonActors("doubt", "the post", mt.actorsInfo).size(), 1);
		assertTrue(mt.getCommonActors("doubt", "the post", mt.actorsInfo).contains("meryl streep"));
		
		// TODO add additional test case scenarios
	}
	
	@Test
	void testGetMean () {
		fail();
		
		// TODO add ALL test case scenarios!
	}
}
