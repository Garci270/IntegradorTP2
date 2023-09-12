package dto;

public class DTOCareerByStudents {
	private String name;
	private long amountStudents;
	
	
	public DTOCareerByStudents() {
		super();		
	}
	
	public DTOCareerByStudents(String name, long amountStudents) {
		super();
		this.name = name;
		this.amountStudents = amountStudents;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public long getAmountStudents() {
		return amountStudents;
	}


	public void setAmountStudents(long amountStudents) {
		this.amountStudents = amountStudents;
	}


	@Override
	public String toString() {
		return "\nCareer: "+this.name+
				"\nNumber of students: "+this.amountStudents+
				"\n---";
	}
	

}
