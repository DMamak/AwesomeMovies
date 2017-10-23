package controllers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import Models.Users;

public class AwsomeMoviesAPI {
	private Map<Long,Users> usersIndex = new HashMap<>();
	
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

	public Users getUser(long id)
	{
		return usersIndex.get(id);
	}
	public void deleteUser(long id) {
		usersIndex.remove(id);
	}
}
