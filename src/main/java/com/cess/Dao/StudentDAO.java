package com.cess.Dao;

import com.cess.connection.ConnectionDB;
import com.cess.dominio.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    void findStudentById(Student student) {

        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConnectionDB.getConnectionBD();
        String sql = "SELECT * FROM student WHERE id_student = "+student.getId_student()+";";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                Student selectedStudent = new Student();

                selectedStudent.setId_student(rs.getInt("id_Student"));
                selectedStudent.setFirst_name(rs.getString("first_name"));
                selectedStudent.setLast_name(rs.getString("last_name"));
                selectedStudent.setPhone(rs.getString("phone"));
                selectedStudent.setEmail(rs.getString("email"));

                System.out.println(selectedStudent);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public List<Student> listStudents() {

        List<Student> students = new ArrayList<>();

        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConnectionDB.getConnectionBD();
        String sql = "SELECT * FROM student ORDER BY id_student;";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()) {
                Student student = new Student();

                student.setId_student(rs.getInt("id_Student"));
                student.setFirst_name(rs.getString("first_name"));
                student.setLast_name(rs.getString("last_name"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));

                students.add(student);
            }

        } catch (Exception e) {
            System.out.println("Ocurrio un error en la consulta: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }

        return students;
    }
    void addStudent() {

    }
    void updateStudent() {

    }
    void deleteStudent() {

    }

    public static void main(String[] args) {
        StudentDAO studentDao = new StudentDAO();
        List<Student> students = studentDao.listStudents();

        // students.forEach(System.out::println);

        studentDao.findStudentById(students.get(1));

    }
}
