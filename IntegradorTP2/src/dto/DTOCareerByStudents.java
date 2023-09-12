package dto;

public class DTOCareerByStudents {
	private String name;
	private int amountStudents;
	
	
	public DTOCareerByStudents() {
		super();		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAmountStudents() {
		return amountStudents;
	}


	public void setAmountStudents(int amountStudents) {
		this.amountStudents = amountStudents;
	}


	public DTOCareerByStudents(String name, int amountStudents) {
		super();
		this.name = name;
		this.amountStudents = amountStudents;
	}


	@Override
	public String toString() {
		return "Career=" + name + ", amountStudents=" + amountStudents + "]";
	}
	

}
