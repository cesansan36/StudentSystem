package com.cess.dominio;

public class Student {
    private int id_student;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;

    public Student() {
    }

    public Student(int id_student) {
        this.id_student = id_student;
    }

    public Student(String first_name, String last_name, String phone, String email) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
    }

    public Student(int id_student, String first_name, String last_name, String phone, String email) {
        this.id_student = id_student;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
    }

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id_student=").append(id_student);
        sb.append(", first_name='").append(first_name).append('\'');
        sb.append(", last_name='").append(last_name).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
