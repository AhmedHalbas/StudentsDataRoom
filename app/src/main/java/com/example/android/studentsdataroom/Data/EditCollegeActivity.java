package com.example.android.studentsdataroom.Data;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.studentsdataroom.Model.College;
import com.example.android.studentsdataroom.Model.CollegeViewModel;
import com.example.android.studentsdataroom.Model.StudentViewModel;
import com.example.android.studentsdataroom.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditCollegeActivity extends AppCompatActivity {

    private Button insertBtn,deleteBtn,backBtn;
    private EditText insertET,deleteET;
    private CollegeViewModel collegeViewModel ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_edit_college);
        insertBtn=findViewById(R.id.insert_btn);
        deleteBtn=findViewById(R.id.delete_btn);
        insertET=findViewById(R.id.insert_et);
        deleteET=findViewById(R.id.delete_et);
        backBtn=findViewById(R.id.back_btn);



        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });


        insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(insertET.getText().toString()=="")
                {
                    Toast.makeText(EditCollegeActivity.this, "Fill The EditText", Toast.LENGTH_SHORT).show();
                }
                collegeViewModel = ViewModelProviders.of(EditCollegeActivity.this).get(CollegeViewModel.class);
                collegeViewModel.insert(new College(insertET.getText().toString()));
                Toast.makeText(EditCollegeActivity.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                insertET.setText("");

            }
        });



        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(deleteET.getText().toString()=="")
                {
                    Toast.makeText(EditCollegeActivity.this, "Fill The EditText", Toast.LENGTH_SHORT).show();
                }

                collegeViewModel = ViewModelProviders.of(EditCollegeActivity.this).get(CollegeViewModel.class);
                collegeViewModel.delete(new College(deleteET.getText().toString()));
                Toast.makeText(EditCollegeActivity.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                deleteET.setText("");


            }
        });




    }





}
