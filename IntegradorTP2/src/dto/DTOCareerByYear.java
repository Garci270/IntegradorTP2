package dto;

public class DTOCareerByYear {
	private int idCareer;
	private String name;
	private long amountEnrolled;
	private long amountGraduated;
	private int year;

	public DTOCareerByYear(int idCareer, String name, long amountEnrolled, long amountGraduated, int year) {
		super();
		this.idCareer = idCareer;
		this.name = name;
		this.amountEnrolled = amountEnrolled;
		this.amountGraduated = amountGraduated;
		this.year = year;
	}

	public int getIdCareer() {
		return idCareer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAmountEnrolled() {
		return amountEnrolled;
	}

	public void setAmountEnrolled(long amountEnrolled) {
		this.amountEnrolled = amountEnrolled;
	}

	public long getAmountGraduated() {
		return amountGraduated;
	}

	public void setAmountGraduated(long amountGraduated) {
		this.amountGraduated = amountGraduated;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "\n[idCareer=" + idCareer + " Career=" + name + ", year=" + year + ", amountEnrolled=" + amountEnrolled + ", amountGraduated="
				+ amountGraduated + "]";
	}

	public DTOCareerByYear() {
		super();
	}

}
