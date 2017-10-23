package Models;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class UsersTest {
	public static Users[] users =
		{
				new Users ("Marek","Mamak","42","M","Builder","E91W594"),
				new Users ("Marek1","Mamak","42","M","Builder","E91W594"),
				new Users ("Marek2","Mamak","42","M","Builder","E91W594"),
				new Users ("Marek3","Mamak","42","M","Builder","E91W594"),
				new Users ("Marek4","Mamak","42","M","Builder","E91W594"),
		};
	
		Users person1=new Users("Damian","Mamak","21","M","Student","E91W594");
		
		@Test
		public void testCreate()
		{
			assertEquals("Damian",          person1.fName);
			assertEquals("Mamak",          person1.lName);
			assertEquals("21",          person1.age);
			assertEquals("M",          person1.gender);
			assertEquals("Student",          person1.occupation);
			assertEquals("E91W594",          person1.zipCode);
		}
		
		@Test
		  public void testIds()
		  {
		    Set<Long> ids = new HashSet<>();
		    for (Users user : users)
		    {
		      ids.add(user.id);
		    }
		    assertEquals (users.length, ids.size());
		  }
@Test
public void testToString()
{
	assertEquals("Users{"+person1.id + ", Damian, Mamak, 21, M, Student, E91W594}",person1.toString());
}
}