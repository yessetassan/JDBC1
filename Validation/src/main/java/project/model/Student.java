package project.model;

import javax.validation.constraints.*;

public class Student {

    private int id_db;

    @NotEmpty(message = "Name shouldn't be empty !")
    private String name;

    @Min(value = 1,message = "Cannot be less than 1")
    @Max(value = 100, message = "Exceed litmi 100 !")
    private int id;
    @NotEmpty(message = "Email shouldn't be empty !")
    @Email(message = "Email incorrect !")
    private String email;
    @Min(value = 0,message = "Min is 0.0 !")
    private double gpa;
    public Student(int id_db, String name, int id, String email, Double gpa) {
        this.id_db = id_db;
        this.name = name;
        this.id = id;
        this.email = email;
        this.gpa = gpa;
    }

    public int getId_db() {
        return id_db;
    }

    public void setId_db(int id_db) {
        this.id_db = id_db;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_db=" + id_db +
                ", name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", gpa=" + gpa +
                '}';
    }

}
