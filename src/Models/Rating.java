package Models;

import static com.google.common.base.MoreObjects.toStringHelper;

public class Rating {
	static Long counter=01L;
	public Long id=0L;
	public float ratings;
	
	public Rating()
	{
		
	}
	public Rating(float ratings)
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
