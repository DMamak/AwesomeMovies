package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RatingTest {

	@Test
	void testCreate()
	{
		Rating one = new Rating(5f);
		assertEquals (5f, one.ratings);
	}
	
	@Test
	public void testIds()
	{
		Rating one = new Rating(5f);
		Rating two = new Rating(3f);
		assertNotEquals(one.id,two.id);
	}
	
	@Test
	public void testToString()
	{
		Rating one = new Rating(5f);
		assertEquals("Rating{3, 5.0}",one.toString());
	}

}
