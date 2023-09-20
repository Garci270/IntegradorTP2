package repositories;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import entity.Career;
import entity.Student;
import entity.StudentHistory;

public class StudentHistoryRepositoryImpl implements StudentHistoryRepository {
	private static StudentHistoryRepositoryImpl instance;
	private EntityManager em;
	
	private StudentHistoryRepositoryImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arquitectura");
		this.em = emf.createEntityManager();
	}
	
	public static StudentHistoryRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new StudentHistoryRepositoryImpl();
		}
		return instance;
	}
	
	@Override
	public void graduateStudent(Student student, Career career) {
		try {
			TypedQuery<StudentHistory> query = this.em.createQuery("SELECT sr FROM StudentHistory sr WHERE sr.student = ?1 AND sr.career = ?2", StudentHistory.class);
			query.setParameter(1, student);
			query.setParameter(2, career);
			StudentHistory sr = query.getSingleResult();
			
			Date current_date = new Date(System.currentTimeMillis());
			this.em.getTransaction().begin();
			sr.setEgressDate(current_date);
			this.em.merge(sr);
			this.em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insertStudentToCareer(Career career, Student student) {
		long miliSeconds = System.currentTimeMillis();
		Date date = new Date(miliSeconds);
		StudentHistory studentHistory = new StudentHistory(student, career, date, null, false);
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

}
