package com.example.android.studentsdataroom.Model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "college_table")
public class College {

    @PrimaryKey
    @NonNull
    private String name;




    public College(String name) {

        this.name = name;

    }



    public String getName() {
        return name;
    }


}