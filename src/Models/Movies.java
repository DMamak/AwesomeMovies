package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Movies {
	static long counter =01L;
	public long id=0L;
	public String title;
	public String releaseDate;
	public String link;
	
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

}
