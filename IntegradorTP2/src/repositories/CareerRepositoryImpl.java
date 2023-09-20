package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.DTOCareerByStudents;
import dto.DTOCareerByYear;
import dto.DTOStudentReport;
import entity.Career;

public class CareerRepositoryImpl implements CareerRepository {
	private static CareerRepositoryImpl instance;
	private EntityManager em;
	
	private CareerRepositoryImpl() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Arquitectura");
		this.em = emf.createEntityManager();
	}
	
	public static CareerRepositoryImpl getInstance() {
		if (instance == null) {
			instance = new CareerRepositoryImpl();
		}
		return instance;
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
	public void getReportOfCareersDetail() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT c FROM StudentHistory sr JOIN sr.career c GROUP BY c.idCareer ORDER BY c.name";
			Query query = em.createQuery(jpql);
			List<Career> career = query.getResultList();
			for (Career c : career) {
				System.out.println(c);
				//jpql = "SELECT s FROM StudentHistory sr JOIN sr.student s WHERE sr.career.idCareer = ?1 ORDER BY sr.egressDate";
				jpql = "SELECT new dto.DTOStudentReport(CONCAT(s.names, ' ', s.lastname), s.numberOfLibrety, sr.inscriptionDate, sr.egressDate, s.residenceCity) FROM StudentHistory sr JOIN sr.student s WHERE sr.career.idCareer = ?1 ORDER BY sr.egressDate";
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DTOCareerByYear> getReportOfCareers() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOCareerByYear(c.name, COUNT(sr.inscriptionDate), COUNT(sr.egressDate), year(sr.inscriptionDate)) FROM StudentHistory sr JOIN sr.career c GROUP BY c.name, year(sr.inscriptionDate) ORDER BY c.name, year(sr.inscriptionDate)";
			Query query = em.createQuery(jpql);
			List<DTOCareerByYear> career = query.getResultList();
			em.getTransaction().commit();
			return career;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	
	


}
