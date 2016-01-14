
public class HighSchoolStudent extends Student {
	String highSchoolName;
	
	public HighSchoolStudent(String n, int id, String schoolName){
		super(n, id);
		this.highSchoolName = schoolName;
	}
	
	public String getNameOfSchool(){
		return highSchoolName;
	}
	
	public void setNameOfSchool(String schoolName){
		this.highSchoolName = schoolName;
	}
	
	public String toString(){
		String str = "";
		str += "High School Student " + Name + "\n";
		str += "Student ID: " + super.toString() + "\n";
		str += "Name of School: " + highSchoolName +"\n";
		return str;
	}

}
