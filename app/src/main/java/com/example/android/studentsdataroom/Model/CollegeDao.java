package com.example.android.studentsdataroom.Model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface CollegeDao {

    @Insert
    void insert(College college);

    @Update
    void update(College college);

    @Delete
    void delete(College college);



    @Query("SELECT name FROM college_table")
    LiveData<List<String>> getAllColleges();



}