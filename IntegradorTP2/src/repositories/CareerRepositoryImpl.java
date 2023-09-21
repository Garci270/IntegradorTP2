package repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import dto.DTOCareerByStudents;
import dto.DTOCareerByYear;
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
	public List<DTOCareerByYear> getReportOfCareers() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT new dto.DTOCareerByYear(c.idCareer, c.name, COUNT(sr.inscriptionDate), COUNT(sr.egressDate), year(sr.inscriptionDate)) FROM StudentHistory sr JOIN sr.career c GROUP BY c.idCareer, c.name, year(sr.inscriptionDate) ORDER BY c.name, year(sr.inscriptionDate)";
			Query query = em.createQuery(jpql);
			List<DTOCareerByYear> career = query.getResultList();
			em.getTransaction().commit();
			return career;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
		
	}
}
