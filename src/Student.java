
public class Student {
	String Name;
	int IDNumber;
	
	public Student(String n, int id){
		this.Name = n;
		this.IDNumber = id;
	}
	
	public String getName(){
		return Name;
	}
	
	public void setName(String n){
		this.Name = n;
	}
	
	public String getIDNumber(){
		String num = Integer.toString(IDNumber);
		return num;
	}
	
	public void setIDNumber(int id){
		this.IDNumber = id;
	}
	
	public String toString(){
		return getIDNumber();
	}
	
}
