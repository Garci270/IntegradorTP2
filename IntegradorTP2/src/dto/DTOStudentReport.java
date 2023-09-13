package dto;

import java.util.Date;

public class DTOStudentReport {
	private String fullname;
	private long numberOfLibrety;
	private Date inscriptionDate;
	private Date egressDate;
	
	public DTOStudentReport() {
		
	}
	
	public DTOStudentReport(String fullname, long numberOfLibrety, Date inscriptionDate, Date egressDate) {
		this.fullname = fullname;
		this.numberOfLibrety = numberOfLibrety;
		this.inscriptionDate = inscriptionDate;
		this.egressDate = egressDate;
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

	@Override
	public String toString() {
		return "\nFullname: "+this.fullname+
				"\nNumber of librety: "+this.numberOfLibrety+
				"\nInscription date: "+this.inscriptionDate+
				"\nEgress date: "+this.egressDate;
	}
}
