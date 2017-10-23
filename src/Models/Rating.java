package Models;

import java.util.ArrayList;
import java.util.List;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Rating {
	static Long counter=01L;
	public Long id=0L;
	public String ratings;
	
	public List<Rating> rating = new ArrayList<>();
	
	public Rating()
	{
		
	}
	public Rating(String ratings)
	{
		this.id=counter++;
		this.ratings=ratings;
	}
	
	@Override
	public String toString()
	{
		return toStringHelper(this).addValue(id)
									.addValue(ratings)
									.toString();
	}

}
