package Models;
import static com.google.common.base.MoreObjects.toStringHelper;

public class Users {
	public int id=0;
	public long counter=1;
	public String fName;
	public String lName;
	public String age;
	public String gender;
	public String occupation;
	public String zipCode;
	
	public Users() {
		
}

	public Users(String fName, String lName, String age, String gender, String occupation, String zipCode) {
		this.id=(int)counter++;
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
