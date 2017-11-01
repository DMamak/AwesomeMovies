package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Objects;

public class Users {
	static long counter=01L;
	public long id=0L;
	public String fName;
	public String lName;
	public String age;
	public String gender;
	public String occupation;
	public String zipCode;
	public Map<Long,Rating> rating = new HashMap<>();
	
	public Users() {
		
}

	public Users(String fName, String lName, String age, String gender, String occupation, String zipCode) {
		this.id=counter++;
		this.fName = fName;
		this.lName = lName;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.zipCode = zipCode;
	}
	@Override
	public String toString()
	{
		return toStringHelper(this).addValue(id)
									.addValue(fName)
									.addValue(lName)
									.addValue(age)
									.addValue(gender)
									.addValue(occupation)
									.addValue(zipCode)
									.toString();
	}

	@Override
	public boolean equals(final Object obj)
	{
		if(obj instanceof Users)
		{
			final Users other = (Users) obj;
			return Objects.equal(fName, other.fName)
					&& Objects.equal(lName, other.lName)
					&& Objects.equal(age, other.age)
					&& Objects.equal(gender, other.gender)
					&& Objects.equal(occupation, other.occupation)
					&& Objects.equal(zipCode, other.zipCode);
		}
		else
		{
			return false;
		}
	}
   
}

