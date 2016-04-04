package com.databasefullfilment;

import com.databasefullfilment.db.ConnectionManager;
import com.databasefullfilment.db.InsertionToDatabase;
import com.databasefullfilment.model.*;
import com.databasefullfilment.network.CourseraService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://%s/%s?user=%s&password=%s";

    public static void main(String[] args){
        String address = "localhost";
        String db = "online_courses";
        String user = "root";
        String password = "789056";
        Connection connection = null;

        try {
            Class.forName(JDBC_DRIVER);
            ConnectionManager.createConnection(String.format(DB_URL, address, db, user, password));

            InsertionToDatabase.insertUniversities(CourseraService.getService().getUniversity().getUniversities());
            System.out.println("All universities was added successfully");

            List<Category> categories = CourseraService.getService().getCategories().getCategories();
            InsertionToDatabase.insertCategories(categories);
            System.out.println("All categories was added successfully");

            List<BasicCourse> basicCourses = CourseraService.getService().getCourses().getBasicCourses();
            List<Session> sessions = CourseraService.getService().getSessions().getSessions();

            ArrayList<Course> courses = new ArrayList<Course>();
            courses.ensureCapacity(basicCourses.size());

            for(BasicCourse basicCourse : basicCourses){
                int sessionNumber = basicCourse.getLinks().getLatestSessionNumber();
                for(Session session: sessions){
                    if(session.getId()== basicCourse.getId()){
                        Course c = new Course(basicCourse);
                        c.setStartDay(session.getStartDay());
                        c.setStartMonth(session.getStartMonth());
                        c.setStartYear(session.getStartYear());
                        courses.add(c);
                    }
                }
            }

            InsertionToDatabase.insertIntoTableCourse(courses);
            System.out.println("All courses was added successfully");

            InsertionToDatabase.insertIntoTableCourse_Subject(categories,courses);
            System.out.println("All categories_courses was added successfully");

            List<Instructor> instructors = CourseraService.getService().getInstructors().getInstructors();

            InsertionToDatabase.insertTeachers(instructors);
            System.out.println("All instructors was added successfully");

            InsertionToDatabase.insertIntoTableTeacher_Course(instructors,courses);
            System.out.println("All instructor_courses was added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
