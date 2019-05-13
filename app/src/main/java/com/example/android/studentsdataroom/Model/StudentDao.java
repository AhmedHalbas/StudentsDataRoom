package com.example.android.studentsdataroom.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert
    void insert(Student student);

    @Update
    void update(Student student);

    @Delete
    void delete(Student student);

    @Query("DELETE FROM student_table")
    void deleteAllStudents();

    @Query("SELECT id,name,CGPA,college,gender FROM student_table ORDER BY id ASC")
    LiveData<List<Student>> getAllStudents();


    @Query("SELECT name FROM student_table")
    LiveData<List<String>> getAllStudentNames();


    @Query("SELECT password FROM student_table")
    LiveData<List<String>> getAllStudentPasswords();
}

