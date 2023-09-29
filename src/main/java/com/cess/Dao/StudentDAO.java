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
    public boolean findStudentById(Student student) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = ConnectionDB.getConnectionBD();
        String sql = "SELECT * FROM student WHERE id_student = ?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, student.getId_student());
            rs = ps.executeQuery();

            if (rs.next()) {
                student.setFirst_name(rs.getString("first_name"));
                student.setLast_name(rs.getString("last_name"));
                student.setPhone(rs.getString("phone"));
                student.setEmail(rs.getString("email"));
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Ocurrio un error en la consulta: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }

        return false;
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

            while (rs.next()) {
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

    public int addStudent(Student student) {
        PreparedStatement ps;
        Connection con = ConnectionDB.getConnectionBD();
        String sql = "INSERT INTO student (first_name, last_name, phone, email) VALUES (?, ?, ?, ?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, student.getFirst_name());
            ps.setString(2, student.getLast_name());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getEmail());
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error en la adicion: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }
        return -1;
    }

    public int updateStudent(Student student) {
        PreparedStatement ps;
        Connection con = ConnectionDB.getConnectionBD();
        String sql = "UPDATE student SET first_name = ?, last_name = ?, phone = ?, email = ? WHERE id_student = ?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, student.getFirst_name());
            ps.setString(2, student.getLast_name());
            ps.setString(3, student.getPhone());
            ps.setString(4, student.getEmail());
            ps.setInt(5, student.getId_student());
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error en la eliminacion: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }
        return -1;
    }

    public int deleteStudent(Student student) {
        PreparedStatement ps;
        Connection con = ConnectionDB.getConnectionBD();
        String sql = "DELETE FROM student WHERE id_student = ?;";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, student.getId_student());
            return ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Ocurrio un error en la eliminacion: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrio un error al cerrar la conexion: " + e.getMessage());
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        StudentDAO studentDao = new StudentDAO();

        /* Buscar por ID */
        // Student student = new Student(1);
        // if (studentDao.findStudentById(student)) {
        // 	System.out.println("Estudiante encontrado:");
        // 	System.out.println(student);
        // }
        // else {
        // 	System.out.println("Estudiante no encontrado");
        // }

        /* Agregar estudiante */
        // Student student2 = new Student("Marcos", "Torres", "34535", "roberto@gmail.com");
        // int afectados = studentDao.addStudent(student2);
        // System.out.println(afectados + " registros afectados");

        /* Actualizar estudiante */
        // Student student3 = new Student(1, "Jaime", "Altozano", "9517536", "JacoboMontanitas@gmail.com");
        // int afectados = studentDao.updateStudent(student3);
        // System.out.println(afectados + " registros afectados");

        /* Eliminar estudiante */
        Student student4 = new Student(5);
        int afectados = studentDao.deleteStudent(student4);
        System.out.println(afectados + " registros afectados");

        /* Listado de estudiantes*/
        List<Student> students = studentDao.listStudents();
        students.forEach(System.out::println);
    }
}
