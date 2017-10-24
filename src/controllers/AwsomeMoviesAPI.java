package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Optional;

import Models.Movies;
import Models.Rating;
import Models.Users;

public class AwsomeMoviesAPI {
	private Map<Long,Users> usersIndex = new HashMap<>();
	private Map<Long, Movies> moviesIndex = new HashMap<>();
//	private Map<Long, Rating> ratingIndex = new HashMap<>();
	//Start of User Controllers
	public Collection<Users> getUsers()
	{
		return usersIndex.values();
	}	
	public void deleteUsers() {
		usersIndex.clear();
	}
	public Users createUser(String fName,String lName,String age,String gender,String occupation,String zipCode) {
		Users user = new Users(fName,lName,age,gender,occupation,zipCode);
		usersIndex.put(user.id,user);
		return user;
	}
	public Users getUser(Long id)
	{
		return usersIndex.get(id);
	}
	public void deleteUser(Long id) {
		usersIndex.remove(id);
	}
	//End of User Controllers
	public void createMovies(Long id,String title,String releaseDate,String link)
	{
		Movies movie = new Movies(title,releaseDate,link);
		Optional<Users>users = Optional.fromNullable(usersIndex.get(id));
		if(users.isPresent()) {
			users.get().movies.put(movie.id, movie);
			moviesIndex.put(movie.id, movie);
		}
	}
	public Movies getMovie(Long id)
	{
		return moviesIndex.get(id);
	}
	public void addRating(Long id, float rating)
	{
		Optional<Movies> movie = Optional.fromNullable(moviesIndex.get(id));
		if(movie.isPresent()) {
			movie.get().ratings.add(new Rating(rating));
		}
	}
	
	
	
}