package com.studentapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // 🔹 CREATE (INSERT)
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, branch, cgpa) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getBranch());
            ps.setDouble(3, student.getCgpa());

            ps.executeUpdate();
            System.out.println("Student added successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 READ (SELECT ALL)
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student(
                        rs.getString("name"),
                        rs.getString("branch"),
                        rs.getDouble("cgpa")
                );
                student.setId(rs.getInt("id")); // important
                students.add(student);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }

    // 🔹 UPDATE (CGPA by ID)
    public boolean updateCgpaById(int id, double newCgpa) {
        String sql = "UPDATE students SET cgpa = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, newCgpa);
            ps.setInt(2, id);

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 🔹 DELETE (by ID)
    public boolean deleteStudentById(int id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            return rowsDeleted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
