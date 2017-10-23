package controllers;

import java.util.ArrayList;
import java.util.List;

import Models.Users;

public class AwsomeMoviesAPI {
	private List<Users>users=new ArrayList<Users>();
	
	public List<Users> getUsers()
	{
		return users;
	}
	
	public void deleteUsers() {
		users.clear();
	}

	public Users createUser(String fName,String lName,String age,String gender,String occupation,String zipCode) {
		Users user = new Users(fName,lName,age,gender,occupation,zipCode);
		users.add(user);
		return user;
	}

	public Users getUser(int id)
	{
		for(Users users:users)
		{
			if(id==users.id)
				return users;
		}
		return null;
	}
	public void deleteUser(int id) {
		Users foundUser=null;
		for(Users users:users)
		{
			if(id==users.id)
				foundUser=users;
		}
		if(foundUser!=null) {
			users.remove(foundUser);
		}
	}
}
