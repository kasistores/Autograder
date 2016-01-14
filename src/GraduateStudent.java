
public class GraduateStudent extends Student{
	String m;
	String a;
	
	public GraduateStudent(String n, int id, String major, String advisor){
		super(n, id);
		this.m = major;
		this.a = advisor;
	}
	
	public String getMajor(){
		return m;
	}
	
	public void setMajor(String major){
		this.m = major;
	}
	
	public String getAdvisor(){
		return a;
	}
	
	public void setAdvisor(String advisor){
		this.a = advisor;
	}
	
	public String toString(){
		String str = "";
		str += "Graduate Student " + Name + "\n";
		str += "Student ID: " + super.toString() + "\n";
		str += "Major: " + m + "\n";
		str += "Advisor: " + a + "\n";
		return str;
	}
}
