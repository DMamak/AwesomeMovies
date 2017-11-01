package controllers;

import java.io.File;
import java.util.Scanner;

import utilities.Serializer;
import utilities.XMLSerializer;

public class Main {
    @SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File datastore = new File("datastore.xml");
		Serializer serializer = new XMLSerializer(datastore);
		AwsomeMoviesAPI awesomemoviesAPI = new AwsomeMoviesAPI(serializer);
		Scanner sc = new Scanner(System.in);
		
		int choice = 0;
		System.out.println("Welcome to the Awesome Movies Program \n");
		System.out.println("Loading the XML Files..... \n");
		if(datastore.isFile())
		{
				awesomemoviesAPI.load();
		}
		System.out.println("Loading Complete \n");
		System.out.println("Loading the .dat files..... \n");
		awesomemoviesAPI.initialLoad();
		System.out.println("Loading Complete \n ");
		
		do {
			System.out.println("Welcome to the Main Menu");
			System.out.println("1.User Menu");
			System.out.println("2.Movies Menu");
			System.out.println("3.Ratings Menu");
			System.out.println("0.Exit Program");
			System.out.println("Please Enter your Option: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				int menu=0;
				do {
				System.out.println("Welcome to the User Menu");
				System.out.println("1.Display all of the Users");
				System.out.println("2.Add a New User");
				System.out.println("3.Delete a User");
				System.out.println("4.Delete all Users");
				System.out.println("5. Get User Rating");
				System.out.println("0.Main Menu");
				System.out.println("Please Enter Your Option:");
				menu=sc.nextInt();
					switch(menu)
					{
					case 1: 
						System.out.println(awesomemoviesAPI.getUsers());
					break;
					case 2 :
						System.out.println("What is Users First Name? :");
						String fName = sc.next();
						System.out.println("What is Users Last Name? : ");
						String lName = sc.next();
						System.out.println("What is Users Age? : ");
						String age = sc.next();
						System.out.println("What is Users Gender(M/F)? :");
						String gender = sc.next();
						System.out.println("What is Users Occupation? : ");
						String occupation = sc.next();
						System.out.println("What is Users Zip-Code ?");
						String zipCode = sc.next();
						awesomemoviesAPI.addUser(fName, lName, age, gender, occupation, zipCode);
						System.out.println("User Added Succesfully");
						break;
					
					case 3: 
						System.out.println("Please enter User Id that you wish to delete: ");
						Long userId = sc.nextLong();
						awesomemoviesAPI.deleteUser(userId);
						System.out.println("User Deleted");
						break;
					
					case 4:
						System.out.println("Deleting all Users.....");
						awesomemoviesAPI.clearUsers();
						System.out.println("All Users have been deleted.");	
						break;
						
					case 5:
						System.out.println("Please enter User Id that you wish to get rating of: ");
						Long userId1 = sc.nextLong();
						System.out.println(awesomemoviesAPI.getUserRating(userId1));
						break;
					}
			     }while(menu != 0);
			  break ; 
			case 2:
				int menu1=0;
				do {
				System.out.println("Welcome to the Movies Menu");
				System.out.println("1.Display all of the Movies");
				System.out.println("2.Add a New Movie");
				System.out.println("3.Delete a Movie");
				System.out.println("4.Delete all Movies");
				System.out.println("5. Get Movie Rating");
				System.out.println("0.Main Menu");
				System.out.println("Please Enter Your Option:");
				menu=sc.nextInt();
					switch(menu1)
					{
					case 1: 
						System.out.println(awesomemoviesAPI.getMovies());
					break;
					case 2 :
						System.out.println("What is Movie Title? :");
						String title = sc.next();
						System.out.println("What is Movie Release Date? : ");
						String releaseDate = sc.next();
						System.out.println("What is Movie Website Link? : ");
						String link = sc.next();
						awesomemoviesAPI.addMovies(title, releaseDate, link);
						System.out.println("Movie Added Succesfully");
						break;
					
					case 3: 
						System.out.println("Please enter Movie Id that you wish to delete: ");
						Long movieId = sc.nextLong();
						awesomemoviesAPI.deleteMovie(movieId);
						System.out.println("Movie Deleted");
						break;
					
					case 4:
						System.out.println("Deleting all Movies.....");
						awesomemoviesAPI.clearMovies();
						System.out.println("All Movies have been deleted.");	
						break;
						
					case 5:
						System.out.println("Please enter User Id that you wish to get rating of: ");
						Long movieId1 = sc.nextLong();
						System.out.println(awesomemoviesAPI.getMovieRating(movieId1));
						break;
					}
			     }while(menu1 != 0);
				
				break;
				
			      case 3:
			    	  int menu2=0;
			    	  do {
			    	  	System.out.println("Welcome to Rating Menu");
			    	  	System.out.println("1.Display All Rating");
			    	  	System.out.println("2.Add a New Rating");
			    	  	System.out.println("3.Display Specific Rating using Rating ID");
			    	  	System.out.println("4.Delete Rating");
			    	  	System.out.println("5.Delete All Ratings");
			    	  	menu2 = sc.nextInt();
			    	  	
			    	  	switch(menu2)
			    	  	{
			    	  	case 1:
			    	  		System.out.println(awesomemoviesAPI.getRatings());
			    	  		break;
			    	  	case 2:
			    	  		 System.out.println("Please enter User ID of the rating");
			    	  		 Long userId2 = sc.nextLong();
			    	  		System.out.println("Please enter Movie ID of the rating");
			    	  		Long movieId2 = sc.nextLong();
			    	  		System.out.println("Please Enter your rating");
			    	  		Float rating = sc.nextFloat();
			    	  		awesomemoviesAPI.addRating(userId2, movieId2, rating);
			    	  		System.out.println("Rating added");
			    	  		break;
			    	  		
			    	  	case 3:
			    	  		System.out.println("Please Enter Rating ID");
			    	  		Long ratingId = sc.nextLong();
			    	  		System.out.println(awesomemoviesAPI.getRating(ratingId));
			    	  		break;
			    	  	case 4: 
			    	  		System.out.println("Please Enter Rating ID");
			    	  		Long ratingId1 = sc.nextLong();
			    	  		awesomemoviesAPI.deleteRating(ratingId1);
			    	  		System.out.println("Rating Deleted");
			    	  		break;
			    	  	case 5:
			    	  		System.out.println("Deleting all Ratings......");
			    	  		awesomemoviesAPI.clearRatings();
			    	  		System.out.println("Ratings Cleared");
			    	  		break;
			    	  	}
			    	  }while(menu2 !=0);
			    	  break;
			}
		}while(choice !=0);
		
		
		
		
	
		System.out.println("Saving Changes to XML....\n");
		awesomemoviesAPI.store();
		System.out.println("Saving Complete \n");
		System.out.println("Thank you for Using the Program.\n Goodbye");
}
}
