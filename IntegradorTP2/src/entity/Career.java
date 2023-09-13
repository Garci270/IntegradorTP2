package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Career {
	@Id
	private int idCareer;
	@Column
	private String name;
	@OneToMany(mappedBy = "career")
	private List<StudentHistory> students;
	
	public Career() {
		// TODO Auto-generated constructor stub
	}

	public Career(int idCareer,String name) {
		super();
		this.idCareer = idCareer;
		this.name = name;
		this.students = new ArrayList<>();
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdCareer() {
		return idCareer;
	}

	public List<StudentHistory> getStudents() {
		return students;
	}
	
	
	@Override
	public String toString() {
		return "\nCareer: "+name;
	}
}
