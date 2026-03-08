package dao;

import java.util.List;
import model.Course;


public interface ICourseDao {

    void addCourse(Course course);
    
    List<Course> getAllCourses();

    void updateCredit(int id, int newCredit);

    List<Course> getCoursesByDepartment(String department);
    
    void deleteAllCourses();
	
    void updateCourse(Course course);


	Course getCourseById(int id);
}


	
