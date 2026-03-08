package main;

import java.util.List;

import dao.CourseDao;
import dao.ICourseDao;
import model.Course;

public class UniversityApp {

    public static void main(String[] args) {

        // Step 1: Create DAO object
        ICourseDao courseDao = new CourseDao();

        // Step 2: Create Course objects
        Course course1 = new Course("OOP", "Computer Engineering", 3);
        Course course2 = new Course("Database Management", "Computer Engineering", 4);
        Course course3 = new Course("Digital Electronics", "Electronics", 3);
        Course course4 = new Course("Operating Systems", "Computer Engineering", 3);

        // Step 3: Save courses to database
        courseDao.addCourse(course1);
        courseDao.addCourse(course2);
        courseDao.addCourse(course3);
        courseDao.addCourse(course4);

        System.out.println("Courses inserted successfully.\n");

        //Step 4: Update course 
        course1.setCourseName("Machine Learning");
        courseDao.updateCourse(course1);
        System.out.println("Course updated successfully.\n");

        // Step 5: Get course by ID
        Course foundCourse = courseDao.getCourseById(course2.getCourseId());
        System.out.println("Course fetched by ID:");
        System.out.println(foundCourse + "\n");

        // Step 6: Get all courses
        List<Course> allCourses = courseDao.getAllCourses();
        System.out.println("All Courses:");
        for (Course c : allCourses) {
            System.out.println(c);
        }

        // Step 7: Update credit
        courseDao.updateCredit(course4.getCourseId(), 15);
        System.out.println("\nCourse credit updated.\n");

        // Step 8: Get courses by department
          List<Course> ceCourses =
                courseDao.getCoursesByDepartment("Computer Engineering");

      System.out.println("Courses in Computer Engineering:");
        for (Course c : ceCourses) {
            System.out.println(c);
        }

        // Step 9: Delete all courses
        /*courseDao.deleteAllCourses();
        System.out.println("\nAll courses deleted.");*/
    }
}
