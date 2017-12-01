package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UsersTest {

	@Test
	public void Usertest() {
		 Users user = new Users("Damian","Mamak","21","M","Student","e91w594");
		 assertEquals(user.fName,"Damian");
		 assertEquals(user.lName,"Mamak");
		 assertEquals(user.age,"21");
		 assertEquals(user.gender,"M");
		 assertEquals(user.password,"Student");
		 assertEquals(user.zipCode,"e91w594");
		 
		 user = new Users("Marek","Mamak","45","M","Builder","e91w594");
		 assertEquals(user.fName,"Marek");
		 assertEquals(user.lName,"Mamak");
		 assertEquals(user.age,"45");
		 assertEquals(user.gender,"M");
		 assertEquals(user.password,"Builder");
		 assertEquals(user.zipCode,"e91w594");
		 
		 user = new Users("Sylwia","Mamak","42","F","Lecturer","e91w594");
		 assertEquals(user.fName,"Sylwia");
		 assertEquals(user.lName,"Mamak");
		 assertEquals(user.age,"42");
		 assertEquals(user.gender,"F");
		 assertEquals(user.password,"Lecturer");
		 assertEquals(user.zipCode,"e91w594");
	}
	
	@Test
	public void toStringTest() {
		Users user = new Users("Damian","Mamak","21","M","Student","e91w594");
		assertEquals(user.toString(),"Users{4, Damian, Mamak, 21, M, Student, e91w594, null}");
	}

}
