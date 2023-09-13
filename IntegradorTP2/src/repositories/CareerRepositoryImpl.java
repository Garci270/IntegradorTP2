package repositories;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import dto.DTOCareerByStudents;
import dto.DTOStudent;
import dto.DTOStudentReport;
import entity.Career;
import entity.Student;
import entity.StudentHistory;

public class CareerRepositoryImpl implements CareerRepository {
	
private EntityManager em;
	
	public CareerRepositoryImpl(EntityManager em) {
		//crear em en constructor y no cerrar conexión
		this.em = em;
	}

	@Override
	public void insertCareer(Career career) {
		try {
			em.getTransaction().begin();
			if(!em.contains(career)) {
				em.persist(career);
			}else {
				em.merge(career);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public void insertStudentToCareer(Career career, Student student) {
		long miliSeconds = System.currentTimeMillis();
		Date date = new Date(miliSeconds);
		StudentHistory studentHistory = new StudentHistory(student, career,date,null , false);
		try {
			em.getTransaction().begin();
			if(!em.contains(studentHistory)) {
				em.persist(studentHistory);
			}else {
				em.merge(studentHistory);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public List<DTOCareerByStudents> getCareersByNumberOfStudents() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOCareerByStudents(c.name, COUNT(c.name))"
					+ " FROM Career c"
					+ " JOIN c.students s"
					+ " GROUP BY c.name"
					+ " HAVING COUNT(c.name) > 0"
					+ " ORDER BY COUNT(c.name) DESC";
			Query query = em.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<DTOCareerByStudents> carres = query.getResultList();
			em.getTransaction().commit();
			return carres;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void getReportOfCareers() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT c FROM StudentHistory sr JOIN sr.career c GROUP BY c.idCareer ORDER BY c.name";
			Query query = em.createQuery(jpql);
			List<Career> career = query.getResultList();
			for (Career c : career) {
				System.out.println(c);
				//jpql = "SELECT s FROM StudentHistory sr JOIN sr.student s WHERE sr.career.idCareer = ?1 ORDER BY sr.egressDate";
				jpql = "SELECT new dto.DTOStudentReport(CONCAT(s.names, ' ', s.lastname), s.numberOfLibrety, sr.inscriptionDate, sr.egressDate) FROM StudentHistory sr JOIN sr.student s WHERE sr.career.idCareer = ?1 ORDER BY sr.egressDate";
				query = em.createQuery(jpql);
				query.setParameter(1, c.getIdCareer());
				List<DTOStudentReport> students = query.getResultList();
				students.forEach(s -> System.out.println(s));
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	//RECUPERAR ESTUDIANTES POR CIUDAD SEGÚN CARRERA
	@Override
	public List<DTOStudent> getStudentsByCareerCity(Career car) {
		try {
			em.getTransaction().begin();
			//String jpql = "SELECT s FROM StudentHistory sh JOIN sh.student s WHERE sh.career = ?1 ORDER BY s.residenceCity";
			//String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety) FROM StudentHistory sh JOIN sh.student s WHERE sh.career.idCareer = ?1 ORDER BY s.residenceCity";
			String jpql = "SELECT new dto.DTOStudent(CONCAT(s.names, ' ', s.lastname), s.age, s.numberOfLibrety) FROM Student s JOIN s.careers c WHERE c.career = ?1 ORDER BY s.residenceCity";
			TypedQuery<DTOStudent> query = em.createQuery(jpql, DTOStudent.class);
			query.setParameter(1, car);
			List<DTOStudent> stus = query.getResultList();
			em.getTransaction().commit();
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}


}
