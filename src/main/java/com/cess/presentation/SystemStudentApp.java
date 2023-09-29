package com.cess.presentation;

import com.cess.Dao.StudentDAO;
import com.cess.dominio.Student;

import java.util.List;
import java.util.Scanner;

public class SystemStudentApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        StudentDAO studentDao = new StudentDAO();

        boolean isExit = false;

        while (!isExit) {
            showMenu();
            isExit = executeOptions(scanner, studentDao);
        }
        scanner.close();
    }

    private static boolean executeOptions(Scanner scanner, StudentDAO studentDao) {
        int option = Integer.parseInt(scanner.nextLine());
        boolean isExit = false;

        switch (option) {
            case 1 -> {
                listStudents(studentDao);
            }
            case 2 -> {
                findById(scanner, studentDao);
            }
            case 3 -> {
                addStudent(scanner, studentDao);
            }
            case 4 -> {
                updateStudent(scanner, studentDao);
            }
            case 5 -> {
                deleteStudent(scanner, studentDao);
            }
            case 6 -> {
                System.out.println("Gracias por usar el sistema");
                isExit = true;
            }
            default -> {
                System.out.println("Opcion ingresada no valida");
            }
        }

        return isExit;
    }

    private static void findById(Scanner scanner, StudentDAO studentDao) {
        System.out.println("Ingrese el id del estudiante a buscar:");
        int id = Integer.parseInt(scanner.nextLine());

        Student student = new Student(id);
        if (studentDao.findStudentById(student)) {
            System.out.println("Student found:");
            System.out.println(student);
        } else {
            System.out.println("Student not found");
        }
    }

    private static void listStudents(StudentDAO studentDao) {

        System.out.println("----- Student List -----");
        List<Student> students = studentDao.listStudents();
        students.forEach(System.out::println);
    }

    private static void deleteStudent(Scanner scanner, StudentDAO studentDao) {

        System.out.println("----- Delete student -----");
        System.out.println("Ingrese el ID del estudiante a eliminar");
        int id = Integer.parseInt(scanner.nextLine());

        Student student = new Student(id);
        int afected = studentDao.deleteStudent(student);
        System.out.println(afected + " registros afectados");
    }

    private static void updateStudent(Scanner scanner, StudentDAO studentDao) {

        System.out.println("----- Update student -----");
        System.out.println("Ingrese el ID del estudiante");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nombre del estudiante");
        String firstName = scanner.nextLine();
        System.out.println("Ingrese el apellido del estudiante");
        String lastName = scanner.nextLine();
        System.out.println("Ingrese el telefono del estudiante");
        String phone = scanner.nextLine();
        System.out.println("Ingrese el correo del estudiante");
        String email = scanner.nextLine();

        Student student = new Student(id, firstName, lastName, phone, email);
        int afected = studentDao.updateStudent(student);
        System.out.println(afected + " registros afectados");
    }

    private static void addStudent(Scanner scanner, StudentDAO studentDao) {

        System.out.println("----- Add new student -----");
        System.out.println("Ingrese el nombre del estudiante");
        String firstName = scanner.nextLine();
        System.out.println("Ingrese el apellido del estudiante");
        String lastName = scanner.nextLine();
        System.out.println("Ingrese el telefono del estudiante");
        String phone = scanner.nextLine();
        System.out.println("Ingrese el correo del estudiante");
        String email = scanner.nextLine();

        Student student = new Student(firstName, lastName, phone, email);
        int afected = studentDao.addStudent(student);
        System.out.println(afected + " registros afectados");
    }

    private static void showMenu() {
        System.out.println("""
                ***** Student List *****
                [1] List Students
                [2] Find Student
                [3] Add Student
                [4] Modify Student
                [5] Delete Student
                [6] Exit

                Seleccione una opción:
                """);
    }
}