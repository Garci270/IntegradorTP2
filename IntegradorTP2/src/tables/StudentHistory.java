package tables;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

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
	@Column
	private boolean graduate;
	
	public StudentHistory() {
		// TODO Auto-generated constructor stub
	}

	public StudentHistory(Student student, Career career, Date inscriptionDate, Date egressDate, boolean graduate) {
		super();
		this.student = student;
		this.career = career;
		this.inscriptionDate = inscriptionDate;
		this.egressDate = egressDate;
		this.graduate = graduate;
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

	public boolean isGraduate() {
		return graduate;
	}

	public void setGraduate(boolean graduate) {
		this.graduate = graduate;
	}

	
	@Override
	public int hashCode() {
		return student.getIdStudent();
	}
	
}
