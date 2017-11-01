package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class Movies {
	static long counter =01L;
	public long id=0L;
	public String title;
	public String releaseDate;
	public String link;
	
	public Map<Long,Rating> rating = new HashMap<>();
	
	public Movies() {
		
	}
	public Movies(String title,String releaseDate,String link)
	{
		this.id=counter++;
		this.title=title;
		this.releaseDate=releaseDate;
		this.link=link;
	}
	
	@Override
	public String toString()
	{
		return toStringHelper(this).addValue(id)
									.addValue(title)
									.addValue(releaseDate)
									.addValue(link)
									.toString();
	}
	
	
	@Override
	public boolean equals(final Object obj)
	{
		if(obj instanceof Movies)
		{
			final Movies other = (Movies) obj;
			return Objects.equal(title, other.title)
					&& Objects.equal(releaseDate, other.releaseDate)
					&& Objects.equal(link, other.link);
		}
		else
		{
			return false;
		}

}
}
