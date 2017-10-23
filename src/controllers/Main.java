package controllers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import Models.Users;
import utilities.FileLogger;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileLogger logger = FileLogger.getLogger();
		logger.log("Creating user list");
		
		List<Users>users=new ArrayList<Users>();
		users.add(new Users("Damian","Mamak","21","M","Student","E91W594"));
		users.add(new Users("Sylwia","Mamak","41","F","Manager","E91W594"));
		users.add(new Users("Robert","Mamak","46","M","Builder","E91W594"));
		System.out.println(users);
		
		logger.log("Serializing contacts to XML");
		XStream xstream = new XStream(new DomDriver());
		ObjectOutputStream out= xstream.createObjectOutputStream(new FileWriter("Users.xml"));
		out.writeObject(users);
		out.close();
		
		logger.log("Finished - Shutting down");

	}

}
