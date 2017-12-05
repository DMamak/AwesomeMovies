package controllers;

import java.io.File;
import java.io.IOException;
import Models.Users;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellDependent;
import asg.cliche.ShellFactory;
import utilities.Serializer;
import utilities.XMLSerializer;

public class Main implements ShellDependent {
	private static final String ADMIN= "admin";
	AwsomeMoviesAPI aweApi = new AwsomeMoviesAPI();
	private Shell theshell;
	
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
	
	
	@Command(description= "Initial CSV Load")
	public void initialLoad() throws IOException
	{
		aweApi.initialLoad();
	}
	
	
	@Command(description="Log in")
	public void logIn(@Param(name = "User Id")long id,@Param(name = "password")String pass) throws IOException
	{
		if(aweApi.login(id, pass)&& aweApi.curUser.isPresent()) {
			Users user = aweApi.curUser.get();
			System.out.println("You are Logged in as " + user.id);
		if(user.role != null && user.role.equals(ADMIN)) {
			AdminMenu adminMenu = new AdminMenu(aweApi, user.fName);
			ShellFactory.createSubshell(user.fName, theshell, "Admin", adminMenu).commandLoop();
		}
		else {
			DefaultMenu defaultMenu = new DefaultMenu(aweApi, user);
			ShellFactory.createSubshell(user.fName, theshell, "Default", defaultMenu).commandLoop();
		}
		}else
			System.out.println("Unknown Username/password");
	}
	
	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Main main = new Main();
		Shell shell= ShellFactory.createConsoleShell("ama", "Welcome to Awesome Movies - ?help  for instructions", main);
		shell.commandLoop();
	
		main.aweApi.store();
}

	@Override
	public void cliSetShell(Shell shell) {
		this.theshell=shell;
		
	}
}
