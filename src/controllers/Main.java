package controllers;

import java.util.ArrayList;
import java.util.List;

import Models.Users;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Users>users=new ArrayList<Users>();
		users.add(new Users("Damian","Mamak","21","M","Student","E91W594"));
		users.add(new Users("Sylwia","Mamak","41","F","Manager","E91W594"));
		users.add(new Users("Robert","Mamak","46","M","Builder","E91W594"));
		System.out.println(users);

	}

}
