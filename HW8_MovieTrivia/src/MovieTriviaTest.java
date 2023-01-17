

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

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
		
		// Testing the Case in which an already present actor is appended 
		mt.insertActor("test1", new String [] {"testmovie1", "testmovie3"}, mt.actorsInfo);
		assertEquals(mt.actorsInfo.size(), 7);
		assertEquals(mt.actorsInfo.get(mt.actorsInfo.size() - 1).getMoviesCast().get(2), "testmovie3");
		
		// Testing formatting requirements 
		mt.insertActor("Thomas Clement      ", new String [] {"The Lion King", "   tHe MaTrIX  "},
				mt.actorsInfo);
		assertEquals(mt.actorsInfo.size(), 8);
		assertEquals(mt.actorsInfo.get(mt.actorsInfo.size() - 1).getMoviesCast().get(1), "the matrix");
		
		
		
		
	}
	
	@Test
	void testInsertRating () {
		mt.insertRating("testmovie", new int [] {79, 80}, mt.moviesInfo);
		assertEquals(mt.moviesInfo.size(), 8);	
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getName(), "testmovie");
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getCriticRating(), 79);
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getAudienceRating(), 80);
		
		// TODO add additional test case scenarios
		
		// Edge case where ratings are greater than 100
		mt.insertRating("   tHe MaTRIX", new int [] {101, 98}, mt.moviesInfo);
		assertEquals(mt.moviesInfo.size(), 8);	
		
		mt.insertRating("   tHe MaTRIX", new int [] {01, 198}, mt.moviesInfo);
		assertEquals(mt.moviesInfo.size(), 8);	
		
		
		// Edge case with formatting errors 
		mt.insertRating("   tHe MaTRIX", new int [] {90, 98}, mt.moviesInfo);
		assertEquals(mt.moviesInfo.size(), 9);	
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getName(), "the matrix");
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getCriticRating(), 90);
		assertEquals(mt.moviesInfo.get(mt.moviesInfo.size() - 1).getAudienceRating(), 98);
		
		
		
	}
	
	@Test
	void testSelectWhereActorIs () {
		assertEquals(mt.selectWhereActorIs("meryl streep", mt.actorsInfo).size(), 3);
		assertEquals(mt.selectWhereActorIs("meryl streep", mt.actorsInfo).get(0), "doubt");
		
		// TODO add additional test case scenarios
		
		// Edge case with incorrect formatting 
		assertEquals(mt.selectWhereActorIs("ToM HanKS     ", mt.actorsInfo).size(), 3);
		assertEquals(mt.selectWhereActorIs("ToM HanKS     ", mt.actorsInfo).get(0), "the post");
	}
	
	@Test
	void testSelectWhereMovieIs () {
		assertEquals(mt.selectWhereMovieIs("doubt", mt.actorsInfo).size(), 2);
		assertEquals(mt.selectWhereMovieIs("doubt", mt.actorsInfo).contains("meryl streep"), true);
		assertEquals(mt.selectWhereMovieIs("doubt", mt.actorsInfo).contains("amy adams"), true);
		
		// TODO add additional test case scenarios
		
		// Edge cast with formatting errors 
		assertEquals(mt.selectWhereMovieIs("ThE POSt   ", mt.actorsInfo).size(), 2);
		assertEquals(mt.selectWhereMovieIs("  tHE POST ", mt.actorsInfo).contains("meryl streep"), true);
		assertEquals(mt.selectWhereMovieIs("the POST", mt.actorsInfo).contains("tom hanks"), true);
		
		
	}
	
	@Test
	void testSelectWhereRatingIs () {
		assertEquals(mt.selectWhereRatingIs('>', 0, true, mt.moviesInfo).size(), 6);
		assertEquals(mt.selectWhereRatingIs('=', 65, false, mt.moviesInfo).size(), 0);
		assertEquals(mt.selectWhereRatingIs('<', 30, true, mt.moviesInfo).size(), 2);
		
		// TODO add additional test case scenarios
		
		// Testing edge cases where targetRating is out of bounds & char is '?'
		assertEquals(mt.selectWhereRatingIs('<', 1000, false, mt.moviesInfo).size(), 0);
		assertEquals(mt.selectWhereRatingIs('>', -1000, false, mt.moviesInfo).size(), 0);
		assertEquals(mt.selectWhereRatingIs('?', 10, true, mt.moviesInfo).size(), 0);
	}
	
	@Test
	void testGetCoActors () {
		assertEquals(mt.getCoActors("meryl streep", mt.actorsInfo).size(), 2);
		assertTrue(mt.getCoActors("meryl streep", mt.actorsInfo).contains("tom hanks"));
		assertTrue(mt.getCoActors("meryl streep", mt.actorsInfo).contains("amy adams"));
		
		// TODO add additional test case scenarios
		
		// Edge case where the input has improper formatting 
		assertEquals(mt.getCoActors("   mEryL sTrEep  ", mt.actorsInfo).size(), 2);
		assertTrue(mt.getCoActors("  MEryl strEEp ", mt.actorsInfo).contains("tom hanks"));
		assertTrue(mt.getCoActors(" meryl streep ", mt.actorsInfo).contains("amy adams"));
		
	}
	
	@Test
	void testGetCommonMovie () {
		assertEquals(mt.getCommonMovie("meryl streep", "tom hanks", mt.actorsInfo).size(), 1);
		assertTrue(mt.getCommonMovie("meryl streep", "tom hanks", mt.actorsInfo).contains("the post"));
		
		// TODO add additional test case scenarios
		
		// Edge case where formatting is incorrect & actor1 = actor2
		assertEquals(mt.getCommonMovie("  Tom hANKS  ", "tom hanks", mt.actorsInfo).size(), 3);
		assertTrue(mt.getCommonMovie("  mERyl strEEp", " ToM hankS", mt.actorsInfo).contains("the post"));
		assertEquals(mt.getCommonMovie("unknown", "unknown1", mt.actorsInfo).size(), 0);
		assertEquals(mt.getCommonMovie("unk   nown", "   Unk  nown  1   ", mt.actorsInfo).size(), 0);
	}
	
	@Test
	void testGoodMovies () {
		assertEquals(mt.goodMovies(mt.moviesInfo).size(), 3);
		assertTrue(mt.goodMovies(mt.moviesInfo).contains("jaws"));
	
		// TODO add additional test case scenarios
		assertTrue(mt.goodMovies(mt.moviesInfo).contains("et"));
		assertTrue(mt.goodMovies(mt.moviesInfo).contains("rocky ii"));
	}
	
	@Test
	void testGetCommonActors () {
		assertEquals(mt.getCommonActors("doubt", "the post", mt.actorsInfo).size(), 1);
		assertTrue(mt.getCommonActors("doubt", "the post", mt.actorsInfo).contains("meryl streep"));
		
		// TODO add additional test case scenarios
		assertEquals(mt.getCommonActors("Not a real movie", "the post", mt.actorsInfo).size(), 0);
		assertTrue(mt.getCommonActors("  DOubT", "the post", mt.actorsInfo).contains("meryl streep"));
		assertTrue(mt.getCommonActors("  FIGHT clUB", "fight club  ", mt.actorsInfo).contains("brad pitt"));
		assertEquals(mt.getCommonActors("  FIGHT clUB", "fight club  ", mt.actorsInfo).size(), 1 );
	}
	
	@Test
	void testGetMean () {
		
		
		// TODO add ALL test case scenarios!
		
		assertEquals(java.util.Arrays.toString(mt.getMean(mt.moviesInfo)),
				"[67.85714285714286, 65.71428571428571]");
		double x = mt.moviesInfo.size();
		assertArrayEquals(new double[] {475/x, 460/x}, mt.getMean(mt.moviesInfo));
		
	}
}
