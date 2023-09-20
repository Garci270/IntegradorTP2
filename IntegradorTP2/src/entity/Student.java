package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student {
	@Id
	private int idStudent;
	@Column(nullable=false)
	private String names;
	@Column(nullable=false)
	private String lastname;
	@Column(nullable=false)
	private int age;
	@Column(nullable=false)
	private String genre;
	@Column(nullable=false)
	private long dni;
	@Column(nullable=false)
	private long numberOfLibrety;
	@Column(nullable=false)
	private String residenceCity;
	@OneToMany(mappedBy = "student")
	private List<StudentHistory> careers;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int idStudent,String names, String lastname, int age, String genre, long dni,long numberOfLibrety, String residenceCity) {
		super();
		this.idStudent = idStudent;
		this.names = names;
		this.lastname = lastname;
		this.age = age;
		this.genre = genre;
		this.dni = dni;
		this.numberOfLibrety = numberOfLibrety;
		this.residenceCity = residenceCity;
		this.careers = new ArrayList<>();
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getResidenceCity() {
		return residenceCity;
	}

	public void setResidenceCity(String residenceCity) {
		this.residenceCity = residenceCity;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public List<StudentHistory> getCareers() {
		return careers;
	}
	
	@Override
	public boolean equals(Object obj) {
		try {
			Student otro = (Student) obj;
			return this.getIdStudent() == otro.getIdStudent();
		} catch (Exception e) {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "\nName: "+this.names+
				"\nLastname: "+this.lastname+
				"\nAge: "+this.age+
				"\nGenre: "+this.genre+
				"\nLibrety of student: "+this.numberOfLibrety+
				"\nResidence city: "+this.residenceCity+
				"\n---";
	}
	
}
