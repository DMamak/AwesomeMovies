package controllers;

import java.util.Collection;
import java.util.Map;

import Models.Movies;
import Models.Rating;
import Models.Users;
import asg.cliche.Command;
import asg.cliche.Param;

public class DefaultMenu {
	private String name;
	private Users user;
	private AwsomeMoviesAPI aweApi;

	public DefaultMenu(AwsomeMoviesAPI aweApi,Users user) {
		this.aweApi= aweApi;
		this.setName(user.fName);
		this.user=user;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	@Command(description ="Get all User Details")
	public void getUsers()
	{
		Collection<Users> users = aweApi.getUsers();
		System.out.println(users);
	}
	
	@Command(description="Search for a User")
	public Users getUser(@Param(name="User Id")long id)
	{
		return aweApi.getUser(id);
	}
	
	@Command(description="Get all Movies")
	public void getMovies()
	{
		Collection<Movies> movies = aweApi.getMovies();
		System.out.println(movies);
	}
	
	@Command(description="Get a Movie")
	public Movies getMovie(@Param(name="Movie Id")long id)
	{
		return aweApi.getMovie(id);
	}
	
	@Command(description="Get All Ratings")
	public void getRatings()
	{
		Collection<Rating> ratings = aweApi.getRatings();
		System.out.println(ratings);
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
	
	
}
