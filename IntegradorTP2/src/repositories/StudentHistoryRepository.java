package repositories;

import entity.Career;
import entity.Student;

public interface StudentHistoryRepository {
	public void insertStudentToCareer(Career career, Student student);
	public void graduateStudent(Student student, Career career);
}
