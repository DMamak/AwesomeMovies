package controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.google.common.base.Optional;
import Models.Movies;
import Models.Rating;
import Models.Users;
import utilities.Serializer;

public class AwsomeMoviesAPI {
	private Serializer serializer;
	private Map<Long,Users> usersIndex = new HashMap<>();
	private Map<Long, Movies> moviesIndex = new HashMap<>();
	private Map<Long, Rating> ratingIndex = new HashMap<>();
	//Serializer to XML Controls
	public AwsomeMoviesAPI() {
		
	}
	public AwsomeMoviesAPI(Serializer serializer)
	{
		this.serializer=serializer;
	}
	@SuppressWarnings("unchecked")
	public void load() throws Exception
	{
		serializer.read();
		usersIndex = (Map<Long,Users>) serializer.pop();
		moviesIndex = (Map<Long,Movies>) serializer.pop();
		ratingIndex = (Map<Long,Rating>) serializer.pop();
	}
	void store() throws Exception
	{
		serializer.push(usersIndex);
		serializer.push(moviesIndex);
		serializer.push(ratingIndex);
		serializer.write();
	}
	//end of Serializer Controls
	
	//Start of User Controls
	public Collection<Users> getUsers()
	{
		return usersIndex.values();
	}	
	public void clearUsers() {
		usersIndex.clear();
	}
	public void addUser(String fName,String lName,String age,String gender,String occupation,String zipCode) {
		Users user = new Users(fName,lName,age,gender,occupation,zipCode);
		usersIndex.put(user.id,user);
	}
	public Users getUser(long id)
	{
		return usersIndex.get(id);
	}
	public void deleteUser(long id) {
		usersIndex.remove(id);
	}
	//End of User Controls
	
	//Start of Movies Controls
	public Collection<Movies> getMovies()
	{
		return moviesIndex.values();
	}
	public void clearMovies()
	{
		moviesIndex.clear();
	}
	public void addMovies(String title,String releaseDate,String link)
	{
		Movies movie = new Movies(title,releaseDate,link);
        moviesIndex.put(movie.id, movie);
	}
	public Movies getMovie(long id)
	{
		return moviesIndex.get(id);
	}
	public void deleteMovie(long id) {
		moviesIndex.remove(id);
	}
	//End of Movies Controls
	public Collection<Rating> getRatings()
	{	
		return ratingIndex.values();
	}
	public void clearRatings()
	{
		ratingIndex.clear();
	}
	public void addRating(long userId,long movieId, float rating)
	{
		Rating ratings = null;
		
		Optional<Users> user = Optional.fromNullable(usersIndex.get(userId));
		Optional<Movies> movie = Optional.fromNullable(moviesIndex.get(movieId));
		if(movie.isPresent() && user.isPresent()) {
			ratings = new Rating(userId,movieId,rating);
			
			movie.get().rating.put(movieId,ratings);
			user.get().rating.put(userId,ratings);
			ratingIndex.put(ratings.ratingId, ratings);
		}
	}
	public Map<Long, Rating> getUserRating(long id) {
		Optional<Users> user = Optional.fromNullable(usersIndex.get(id));
			return user.get().rating;
	}
	
			public Map<Long, Rating> getMovieRating(long id) {
				Optional<Movies> movie = Optional.fromNullable(moviesIndex.get(id));
					return movie.get().rating;		
		
	}
    public Rating getRating(long id)
    {
    	return ratingIndex.get(id);
    }
    public void deleteRating(long id)
    {
    	ratingIndex.remove(id);
    }
    public void initialLoad() throws IOException
    {
    	 String delims = "[|]";
         Scanner scanner  = new Scanner (new File("users5.dat"));
         while (scanner.hasNextLine()) {
             String userDetails = scanner.nextLine();
             // parse user details string
             String[] userTokens = userDetails.split(delims);
             if (userTokens.length == 7) {
                 addUser(userTokens[1],userTokens[2],userTokens[3],userTokens[4],userTokens[5],userTokens[6]);
             } else {
                 scanner.close();
                 throw new IOException("Invalid member length: " + userTokens.length);
             }
         }
         scanner.close();
         
             Scanner scanner1 = new Scanner( new File("items5.dat"));
             while (scanner1.hasNextLine()) {
                String userDetails1 = scanner1.nextLine();
                 // parse user details string
                String[]  userTokens1 = userDetails1.split(delims);
                 if (userTokens1.length == 23) {
                     addMovies(userTokens1[1],userTokens1[2],userTokens1[3]);
                 } else {
                     scanner1.close();
                     throw new IOException("Invalid member length: " + userTokens1.length);
                 }
             }
             scanner1.close();
                 
            Scanner scanner2 = new Scanner (new File("ratings5.dat"));
                 while (scanner2.hasNextLine()) {
                   String  userDetails2 = scanner2.nextLine();
                     // parse user details string
                    String[]  userTokens2 = userDetails2.split(delims);
                     if (userTokens2.length == 4) {
                         addRating(Long.valueOf(userTokens2[0]),Long.valueOf(userTokens2[1]),Float.valueOf(userTokens2[2]));
                     } else {
                         scanner2.close();
                         throw new IOException("Invalid member length: " + userTokens2.length);
                     }
        
             }
                 scanner2.close();
         }
}
    

    


    
