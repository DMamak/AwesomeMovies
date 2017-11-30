package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import Models.Movies;
import Models.Rating;
import Models.Users;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;
import utilities.Serializer;
import utilities.XMLSerializer;

public class Main {
	AwsomeMoviesAPI aweApi;
	
	@Command(description= "Initial CSV Load")
	public void initialLoad() throws IOException
	{
		aweApi.initialLoad();
	}
	
	@Command(description ="Get all User Details")
	public void getUsers()
	{
		Collection<Users> users = aweApi.getUsers();
		System.out.println(users);
	}
	@Command(description="Delete ALL Users")
	public void clearUsers()
	{
		aweApi.clearUsers();
	}
	
	@Command(description="Create new User")
	public void addUser(@Param(name="First Name") String fname,@Param(name="Last Name") String lname,@Param(name="Age") String age,@Param(name="Gender") String gender,
			@Param(name="password") String password,@Param(name="zipCode") String zipCode)
	{
		aweApi.addUser(fname,lname,age,gender,password,zipCode);
	}
	@Command(description="Search for a User")
	public Users getUser(@Param(name="User Id")long id)
	{
		return aweApi.getUser(id);
	}
	
	@Command(description="Delete a User")
	public void deleteUser(@Param(name="User ID")long id)
	{
		aweApi.deleteUser(id);
	}
	
	@Command(description="Get all Movies")
	public void getMovies()
	{
		aweApi.getMovies();
	}
	
	@Command(description="Clear all movies")
	public void clearMovies()
	{
		aweApi.clearMovies();
	}
	
	@Command(description="Add a new Movie")
	public void addMovie(@Param(name="Title")String title,@Param(name="Release Date")String releaseDate,@Param(name="Link")String link)
	{
		aweApi.addMovies(title, releaseDate, link);
	}
	
	@Command(description="Get a Movie")
	public Movies getMovie(@Param(name="Movie Id")long id)
	{
		return aweApi.getMovie(id);
	}
	
	@Command(description="Delete Movie")
	public void deleteMovie(@Param(name="Movie Id")long id)
	{
		aweApi.deleteMovie(id);
	}
	
	@Command(description="Get All Ratings")
	public void getRatings()
	{
		aweApi.getRatings();
	}
	
	@Command(description="Clear all Ratings")
	public void clearRating()
	{
		aweApi.clearRatings();
	}

	@Command(description="Adding a new Rating")
	public void addRating(@Param(name="User id")long UserId,@Param(name="Movies Id")long movieId,@Param(name="Rating Value")float rating)
	{
		aweApi.addRating(UserId, movieId, rating);
	}
	
	@Command(description="Get User Ratings")
	public Map<Long,Rating> getUserRating(@Param(name="User ID")long id)
	{
		return aweApi.getUserRating(id);
	}
	
	@Command(description="Get Movies Ratings")
	public Map<Long,Rating> getMovieRating(@Param(name="Movie Id")long id)
	{
		return aweApi.getMovieRating(id);
	}
	
	@Command(description="Return a Rating")
	public Rating getRating(@Param(name="Rating Id")long id)
	{
		return aweApi.getRating(id);
	}
	@Command(description="Delete a Rating")
	public void deleteRating(@Param(name="Rating Id")long id)
	{
		aweApi.deleteRating(id);
	}

public Main () throws Exception
	{
		File datastore = new File("datastore.xml");
		Serializer serializer = new XMLSerializer(datastore);
		
		aweApi = new AwsomeMoviesAPI(serializer);
		
		if(datastore.isFile())
		{
			aweApi.load();
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Main main = new Main();
		Shell shell= ShellFactory.createConsoleShell("ama", "Welcome to Awesome Movies - ?help  for instructions", main);
		shell.commandLoop();
	
		main.aweApi.store();
}
}
