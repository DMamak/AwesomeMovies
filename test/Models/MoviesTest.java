package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoviesTest {

	@Test
	public void moviesTest()
	{
		Movies movie = new Movies("ToyStory","2005","https://");
		assertEquals(movie.title, "ToyStory");
		assertEquals(movie.releaseDate, "2005");
		assertEquals(movie.link, "https://");
		
		movie = new Movies("Thor","2012","https://");
		assertEquals(movie.title, "Thor");
		assertEquals(movie.releaseDate, "2012");
		assertEquals(movie.link, "https://");
		
		movie = new Movies("Ironman","2009","https://");
		assertEquals(movie.title, "Ironman");
		assertEquals(movie.releaseDate, "2009");
		assertEquals(movie.link, "https://");
	}
	
	@Test
	public void toStringTest() {
		Movies movie = new Movies("Avengers","2014","https://");
		assertEquals(movie.toString(),"Movies{4, Avengers, 2014, https://}");
	}

}
