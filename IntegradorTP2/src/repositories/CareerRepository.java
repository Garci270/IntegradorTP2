package repositories;

import java.util.List;

import dto.DTOCareerByStudents;
import dto.DTOCareerByYear;
import entity.Career;

public interface CareerRepository {
	
	public void insertCareer(Career career);
	public List<DTOCareerByStudents> getCareersByNumberOfStudents();
	public void getReportOfCareersDetail();
	public List<DTOCareerByYear> getReportOfCareers();

}
