package Models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoviesTest {
		private Movies[] movies = 
			{
					new Movies("ToyStory","October","derp"),
					new Movies("ToyStory2","October2","derp2"),
					new Movies("ToyStory3","October3","derp3"),
					new Movies("ToyStory4","October4","derp4"),
					new Movies("ToyStory5","October5","derp5")
			};
		
		Movies test = new Movies("ToyStory","October","derp");
		
		@Test
		public void testCreate()
		{
			assertEquals("ToyStory",test.title);
			assertEquals("October",test.releaseDate);
			assertEquals("derp",test.link);
		}
		
		@Test
		public void testToString()
		{
			assertEquals("Movies{"+test.id+", ToyStory, October, derp}",test.toString());
		}
		
		
}
