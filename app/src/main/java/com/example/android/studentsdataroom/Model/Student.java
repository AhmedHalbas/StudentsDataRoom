package com.example.android.studentsdataroom.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {

    @PrimaryKey
    private int id;

    private String name;

    private Double CGPA;

    private String college;

    private String gender;

    private String password;




    public Student(int id, String name, Double CGPA, String college, String gender, String password) {
        this.id = id;
        this.name = name;
        this.CGPA = CGPA;
        this.college = college;
        this.gender = gender;
        this.password = password;
    }





    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCGPA() {
        return CGPA;
    }

    public String getCollege() {
        return college;
    }

    public String getGender() {
        return gender;
    }

    public String getPassword() {
        return password;
    }
}