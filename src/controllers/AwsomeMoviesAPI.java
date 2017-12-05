package controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.google.common.base.Optional;
import Models.Movies;
import Models.Rating;
import Models.Users;
import utilities.ComparatorByID;
import utilities.Serializer;

public class AwsomeMoviesAPI {
	private Serializer serializer;
	private Map<Long,Users> usersIndex = new HashMap<>();
	private Map<Long, Movies> moviesIndex = new HashMap<>();
	private Map<Long, Rating> ratingIndex = new HashMap<>();
	public Optional<Users> curUser;
	//Serializer to XML Controls
	public AwsomeMoviesAPI() {
		
	}
	public AwsomeMoviesAPI(Serializer serializer)
	{
		this.serializer=serializer;
	}
	
	public List<Movies> searchMovie (String word)
	{
		List<Movies> foundMovie = new ArrayList<Movies>();
		
		for(long i : moviesIndex.keySet())
		{
			if(moviesIndex.get(i).title.toLowerCase().contains(word.toLowerCase()))
					{
				foundMovie.add(moviesIndex.get(i));
					}
		}
		return foundMovie;
	}
	
	public void Top10Movies()
	{
		List<Movies> list = new ArrayList<Movies>(moviesIndex.values());
		Collections.sort(list, new ComparatorByID().reversed());
		Iterator<Movies> iter = list.iterator();
		while (iter.hasNext()) {
			Movies s = iter.next();
			System.out.println(s.title + "  " + (s.ratingSum / s.rating.size()));
	}
	}
	
	public void Top5Movies(long id)
	{
		 Map<Long,Movies> MovieIndex2 = new HashMap<>();
		 MovieIndex2.putAll(moviesIndex);
		 
		Optional<Users> user = Optional.fromNullable(usersIndex.get(id));
		Set<Long> list;
		list= user.get().rating.keySet();
		Iterator<Long> iter = list.iterator();
		while(iter.hasNext()) {
			long s = iter.next();
			Rating temp = ratingIndex.get(s);
			s = temp.movieId;
			MovieIndex2.remove(s);
		}
		
		List<Movies> list2 = new ArrayList<Movies>(MovieIndex2.values());
		Collections.sort(list2, new ComparatorByID().reversed());
		Iterator<Movies> iter2 = list2.iterator();
		while (iter2.hasNext()) {
			Movies s = iter2.next();
			System.out.println(s.title + "  " + (s.ratingSum / s.rating.size()));
	}
		
		
		
		
	}
	// Login Methods for Cliche//
	public boolean login(Long id,String password)
	{
		Optional<Users> user = Optional.fromNullable(usersIndex.get(id));
		if(user.isPresent() && user.get().password.equals(password)) {
			curUser = user;
			System.out.println(curUser.get().id + ""+curUser.get().fName + "logged in ...");
			return true;
		}
		return false;
	}
	
	public void logout()
	{
		Optional<Users> user=curUser;
		if(user.isPresent()) {
			System.out.println(curUser.get().id + ""+curUser.get().fName + "logged out ...");
			curUser=Optional.absent();
		}
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
		serializer.push(ratingIndex);
		serializer.push(moviesIndex);
		serializer.push(usersIndex);
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
	public Users addUser(String fName,String lName,String age,String gender,String password,String zipCode) {
		Users user = new Users(fName,lName,age,gender,password,zipCode);
		usersIndex.put(user.id,user);
		return user;
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
			
			movie.get().rating.put(ratings.ratingId, ratings);
			user.get().rating.put(ratings.ratingId,ratings);
			ratingIndex.put(ratings.ratingId, ratings);
			movie.get().ratingSum = movie.get().ratingSum + rating ;
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
