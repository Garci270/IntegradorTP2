package dto;

public class DTOStudent {
	private String fullname;
	private int age;
	private long numberOfLibrety;
	
	public DTOStudent() {
		
	}
	
	public DTOStudent(String fullname, int age, long numberOfLibrety) {
		this.fullname = fullname;
		this.age = age;
		this.numberOfLibrety = numberOfLibrety;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getNumberOfLibrety() {
		return numberOfLibrety;
	}

	public void setNumberOfLibrety(long numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}

	@Override
	public String toString() {
		return "\nFullname: "+this.fullname+
				"\nAge:"+this.age+
				"\nNumber of librety: "+this.numberOfLibrety+
				"\n---";
	}
}
