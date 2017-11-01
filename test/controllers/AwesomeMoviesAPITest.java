package controllers;

import static org.junit.jupiter.api.Assertions.*;
import controllers.AwsomeMoviesAPI;
import org.junit.jupiter.api.Test;

import Models.Movies;
import Models.Users;

class AwesomeMoviesAPITest {
	
	private AwsomeMoviesAPI awesomemovies = new AwsomeMoviesAPI();
	

	@Test
	public void testUser() {
		Users p1 = new Users("Damian","Mamak","21","M","Student","E91W594");
		assertEquals(0, awesomemovies.getUsers().size());
		awesomemovies.addUser("Damian", "Mamak", "21", "M", "Student", "E91W594");
		assertEquals(1, awesomemovies.getUsers().size());
		assertEquals(p1,awesomemovies.getUser(2));
	}
	
	@Test
	public void testDeleteUser()
	{
		assertEquals(0, awesomemovies.getUsers().size());
		awesomemovies.addUser("Damian", "Mamak", "21", "M", "Student", "E91W594");
		awesomemovies.addUser("Robert", "Mamak", "42", "M", "Builder", "E91W594");
		assertEquals(2, awesomemovies.getUsers().size());
		awesomemovies.deleteUser(4);
		assertEquals(1,awesomemovies.getUsers().size());
	}
	@Test
	public void testMovie()
	{
		Movies m1 = new Movies("Avengers","2014","https://");
		assertEquals(0, awesomemovies.getMovies().size());
		awesomemovies.addMovies("Avengers", "2014", "https://");
		assertEquals(1, awesomemovies.getMovies().size());
		assertEquals(m1,awesomemovies.getMovie(4));
	}
	@Test
	public void testDeleteMovie()
	{
		assertEquals(0, awesomemovies.getMovies().size());
		awesomemovies.addMovies("Avengers", "2014", "https://");
		awesomemovies.addMovies("Thor", "2007","https://");
		assertEquals(2, awesomemovies.getMovies().size());
		awesomemovies.deleteMovie(2);
		assertEquals(1,awesomemovies.getMovies().size());
	}
	
}