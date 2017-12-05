package utilities;

import java.util.Comparator;

import Models.Movies;

public class ComparatorByID implements Comparator<Movies> {
	@Override
	public int compare(Movies s1, Movies s2) {
		
		return (int) (s1.ratingSum - s2.ratingSum);
	}

}
