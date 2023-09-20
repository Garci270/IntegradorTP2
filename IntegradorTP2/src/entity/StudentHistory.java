package entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class StudentHistory implements Serializable {
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idStudent")
	private Student student;
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idCareer")
	private Career career;
	@Column(nullable = false)
	private Date inscriptionDate;
	@Column(nullable = true)
	private Date egressDate;
	
	public StudentHistory() {
		// TODO Auto-generated constructor stub
	}

	public StudentHistory(Student student, Career career, Date inscriptionDate, Date egressDate, boolean graduate) {
		super();
		this.student = student;
		this.career = career;
		this.inscriptionDate = inscriptionDate;
		this.egressDate = egressDate;
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Date getInscription() {
		return inscriptionDate;
	}

	public void setInscription(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			StudentHistory otro = (StudentHistory) obj;
			return this.getStudent().equals(otro.getStudent()) && this.getCareer().equals(otro.getCareer());
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return student.getIdStudent();
	}
	
}
