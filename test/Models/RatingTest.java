package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RatingTest {
	@Test
	public void ratingTest()
	{
		Rating rating = new Rating(1L,1L,2.0f);
		assertSame(rating.userId, 1L);
		assertSame(rating.movieId, 1L);
		assertEquals(rating.ratings, 2.0f);
		
		rating = new Rating(2L,1L,5.0f);
		assertSame(rating.userId,2L);
		assertSame(rating.movieId,1L);
		assertEquals(rating.ratings,5.0f);
		
		rating = new Rating(2L,3L,10.0f);
		assertSame(rating.userId,2L);
		assertSame(rating.movieId,3L);
		assertEquals(rating.ratings,10.0f);
	}
	
	@Test
	public void toStringTest() {
		Rating rating = new Rating(3L,2L,3.0f);
		assertEquals(rating.toString(),"Rating{1, 3, 2, 3.0}");
	}
}
