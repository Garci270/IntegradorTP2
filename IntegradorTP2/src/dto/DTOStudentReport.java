package dto;

import java.util.Date;

public class DTOStudentReport {
	private String fullname;
	private long numberOfLibrety;
	private Date inscriptionDate;
	private Date egressDate;
	private String city;
	
	public DTOStudentReport() {
		
	}
	
	public DTOStudentReport(String fullname, long numberOfLibrety, Date inscriptionDate, Date egressDate, String city) {
		this.fullname = fullname;
		this.numberOfLibrety = numberOfLibrety;
		this.inscriptionDate = inscriptionDate;
		this.egressDate = egressDate;
		this.city = city;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public long getNumberOfLibrety() {
		return numberOfLibrety;
	}

	public void setNumberOfLibrety(long numberOfLibrety) {
		this.numberOfLibrety = numberOfLibrety;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public Date getEgressDate() {
		return egressDate;
	}

	public void setEgressDate(Date egressDate) {
		this.egressDate = egressDate;
	}
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "[Fullname: "+this.fullname+
				", Number of librety: "+this.numberOfLibrety+
				", Inscription date: "+this.inscriptionDate+
				", Egress date: "+this.egressDate+
				", City: "+this.city+"]";
	}
}
