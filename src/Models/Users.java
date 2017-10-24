package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

import java.util.HashMap;
import java.util.Map;

public class Users {
	static long counter=01L;
	public long id=0L;
	public String fName;
	public String lName;
	public String age;
	public String gender;
	public String occupation;
	public String zipCode;
	public Map<Long,Movies> movies = new HashMap<>();
	
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

}
