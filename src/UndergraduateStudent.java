
public class UndergraduateStudent extends Student {
	String m;
	
	public UndergraduateStudent(String n, int id, String major){
		super(n, id);
		this.m = major;
	}
	
	public String getMajor(){
		return m;
	}
	
	public void setMajor(String major){
		this.m = major;
	}
	
	public String toString(){
		String str = "";
		str += "Undergraduate Student " + Name + "\n";
		str += "Student ID: " + super.toString() + "\n";
		str += "Major: " + m + "\n";
		return str;
	}
}
