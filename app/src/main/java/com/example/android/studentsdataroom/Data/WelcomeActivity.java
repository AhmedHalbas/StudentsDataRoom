package com.example.android.studentsdataroom.Data;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.studentsdataroom.R;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeTextview;
    Button insertStudentButton,viewStudentButton,editCollegeButton,logoutButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        welcomeTextview=findViewById(R.id.welcome_tv);
        insertStudentButton=findViewById(R.id.choose_insert_student);
        viewStudentButton=findViewById(R.id.choose_view_students);
        editCollegeButton=findViewById(R.id.choose_edit_college);
        logoutButton=findViewById(R.id.logout_btn);

        Bundle b = getIntent().getExtras();
        String username = b.getString("userName");

        welcomeTextview.setText("Welcome "+username);

        insertStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(WelcomeActivity.this, InsertStudentActivity.class));
            }
        });


        viewStudentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(WelcomeActivity.this, ViewStudentsActivity.class));
            }
        });


        editCollegeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(WelcomeActivity.this, EditCollegeActivity.class));
            }
        });


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });



    }



}
