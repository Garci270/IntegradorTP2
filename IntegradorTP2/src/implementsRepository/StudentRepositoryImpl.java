package implementsRepository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import repositories.StudentRepository;
import tables.Career;
import tables.Student;

public class StudentRepositoryImpl implements StudentRepository {
	
	private EntityManager em;
	
	public StudentRepositoryImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void insertStudent(Student student) {
		try {
			em.getTransaction().begin();
			if(!em.contains(student)) {
				em.persist(student);
			}else {
				em.merge(student);
			}
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Student getStudentByNumberOfLibrety(long number) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT s FROM Student s WHERE s.numberOfLibrety = ?1";
			Query query = em.createQuery(jpql);
			query.setParameter(1, number);
			Student stu = (Student) query.getSingleResult();
			em.getTransaction().commit();
			return stu;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Student> getStudentsBySimpleOrdering() {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT s FROM Student s ORDER BY s.lastname";
			Query query = em.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<Student> stus = query.getResultList();
			em.getTransaction().commit();
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Student> getStudentsByGenre(String genre) {
		try {
			em.getTransaction().begin();
			String jpql = "SELECT s FROM Student s WHERE s.genre = ?1";
			Query query = em.createQuery(jpql);
			query.setParameter(1, genre);
			@SuppressWarnings("unchecked")
			List<Student> stus = query.getResultList();
			em.getTransaction().commit();
			return stus;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
