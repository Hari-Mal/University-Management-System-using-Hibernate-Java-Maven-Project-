package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import model.Course;

import util.HibernateUtil;

public class CourseDao implements ICourseDao {

    @Override
    public void addCourse(Course course) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	transaction = session.beginTransaction();
            session.persist(course);
            transaction.commit();
        }  catch (Exception e) { 
	        if (transaction!= null) { 
	        	transaction.rollback(); 
            } 
        }
        
    }
    @Override
	public void updateCourse(Course course) {
		Transaction transaction = null; 
        try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
           transaction = session.beginTransaction(); 
            session.merge(course); 
            transaction.commit(); 
        } catch (Exception e) { 
            if (transaction != null) { 
                transaction.rollback(); 
            } 
        }
		
		
	}

    
    @Override
	public Course getCourseById(int id) {
	     Transaction transaction = null; 
	        Course course = null; 
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
	            transaction = session.beginTransaction(); 
	            course = session.get(Course.class, id); 
	            transaction.commit(); 
	        } catch (Exception e) { 
	            if (transaction != null) { 
	                transaction.rollback(); 
	            } 
	        } 
		
		return course;
	}

   
    
    public List<Course> getAllCourses() {
	     Transaction transaction = null; 
	        List < Course > course = null; 
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) { 
	            transaction = session.beginTransaction(); 
	            JpaCriteriaQuery<Course> cq = session.getCriteriaBuilder().createQuery(Course.class);
	            cq.from(Course.class);
	            course = session.createQuery(cq).getResultList(); 
	            transaction.commit(); 
	        } catch (Exception e) { 
	            if (transaction != null) { 
	                transaction.rollback(); 
	            } 
	        } 
	        return course;
	}

   
    @Override
    public void updateCredit(int id, int newCredit) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	transaction= session.beginTransaction();
            Course course = session.get(Course.class, id);
            course.setCredit(newCredit);
            session.merge(course);
            transaction.commit();
        } 
      catch (Exception e) { 
        if (transaction!= null) { 
        	transaction.rollback(); 
        } 
    }
    
    }

   
    @Override
    public List<Course> getCoursesByDepartment(String department) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "from Course where department = :dept", Course.class)
                .setParameter("dept", department)
                .list();
        }
    }
    @Override
    public void deleteAllCourses() {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	transaction = session.beginTransaction();

            session.createMutationQuery("delete from Course").executeUpdate();


            transaction.commit();
        } 
      catch (Exception e) { 
        if (transaction!= null) { 
        	transaction.rollback(); 
        } 
    }
    
    }
	

}
