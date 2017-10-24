package Models;

import static org.junit.jupiter.api.Assertions.*;
import static Models.Fixtures.users;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class UsersTest {
	
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