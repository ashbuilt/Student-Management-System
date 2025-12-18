package com.studentapp;

import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student CGPA");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter branch: ");
                    String branch = sc.nextLine();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    dao.addStudent(new Student(name, branch, cgpa));
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\n--- Students List ---");
                    for (Student s : students) {
                        System.out.println(
                                "Name: " + s.getName() +
                                ", Branch: " + s.getBranch() +
                                ", CGPA: " + s.getCgpa()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    int idToUpdate = sc.nextInt();

                    System.out.print("Enter new CGPA: ");
                    double newCgpa = sc.nextDouble();

                    if (dao.updateCgpaById(idToUpdate, newCgpa)) {
                        System.out.println("CGPA updated successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to delete: ");
                    int idToDelete = sc.nextInt();

                    if (dao.deleteStudentById(idToDelete)) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting application.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
