package com.databasefullfilment.db;

import com.databasefullfilment.model.Category;
import com.databasefullfilment.model.Course;
import com.databasefullfilment.model.Instructor;
import com.databasefullfilment.model.University;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class InsertionToDatabase {
    private static PreparedStatement stmt = null;
    private static Connection connection = ConnectionManager.getConnection();

    public static boolean universityWithCurrentIdExist(int id){
        try {
            PreparedStatement stmt1 = connection.prepareStatement("SELECT * FROM University WHERE university_id = ?;");
            stmt1.setInt(1,id);
            ResultSet rs = stmt1.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static void insertTeachers(List<Instructor> instructors) {
        try {
            stmt = connection.prepareStatement("INSERT Teacher values(?,?,?,?)");
            for (Instructor i : instructors) {
                stmt.setInt(1, i.getId());
                if(i.getLinks() == null || !universityWithCurrentIdExist(i.getLinks().getLastUniversityId()))
                    stmt.setString(2, null);
                else
                    stmt.setInt(2,i.getLinks().getLastUniversityId());
                stmt.setString(3, i.getLastName());
                stmt.setString(4, i.getFirstName());
                stmt.executeUpdate();
            }
            System.out.println("Teachers has been successfully added");
        } catch (SQLException e) {
            System.out.println(stmt.toString());
            e.printStackTrace();
        }
    }

    public static void insertUniversities(List<University> universities) {
        try {
            stmt = connection.prepareStatement("INSERT University values(?,?)");
            for (University u : universities) {
                stmt.setInt(1, u.getId());
                stmt.setString(2, u.getName());
                stmt.executeUpdate();
            }
            System.out.println("Universities has been successfully added");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCategories(List<Category> categories) {

        try {
            stmt = connection.prepareStatement("INSERT Subject values(?,?)");
            for (Category c : categories) {
                stmt.setInt(1, c.getId());
                stmt.setString(2, c.getName());
                stmt.executeUpdate();
            }
            System.out.println("Categories has been successfully added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertIntoTableCourse_Subject(List<Category> categories, List<Course> courses) {
        try {
            stmt = connection.prepareStatement("INSERT INTO Subject_Course(subject_id,course_id) " +
                    "VALUES(?,?)");
            for (Course course : courses) {
                int[] course_categories = course.getLinks().getCaregories();
                for (int i = 0; i < course_categories.length; ++i) {
                    for (Category category : categories) {
                        if (course_categories[i] == category.getId()) {
                            stmt.setInt(1, category.getId());
                            stmt.setInt(2, course.getId());
                            stmt.executeUpdate();
                            break;
                        }
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoTableTeacher_Course(List<Instructor> instructors, List<Course> courses) {
        try {
            stmt = connection.prepareStatement("INSERT INTO Teacher_Course(teacher_id, course_id) VALUES(?,?)");

            for (Instructor i : instructors) {
                if (i.getLinks() == null || i.getLinks().getaCourseId() == null || i.getLinks().getaCourseId().length == 0)
                    continue;
                for (Course c : courses) {
                    if (Arrays.asList(i.getLinks().getaCourseId()).contains(c.getId())) {
                        stmt.setInt(1, i.getId());
                        stmt.setInt(2, i.getId());
                        stmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoTableCourse(List<Course> courses) {
        try {
            stmt = connection.prepareStatement("INSERT Course VALUES(?,?,?,? + INTERVAL ? WEEK,?,?)");
            for (Course c : courses) {
                stmt.setInt(1, c.getId());
                stmt.setString(2, c.getName());
                stmt.setString(3, c.getBeginDate());
                stmt.setString(4, c.getBeginDate());
                stmt.setString(5, c.getEndDate());
                stmt.setString(6, c.getDescription());
                stmt.setString(7, c.getLink());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
