package com.example.android.studentsdataroom.Data;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.android.studentsdataroom.Model.CollegeViewModel;
import com.example.android.studentsdataroom.Model.Student;
import com.example.android.studentsdataroom.Model.StudentViewModel;
import com.example.android.studentsdataroom.R;

import java.util.ArrayList;
import java.util.List;

public class InsertStudentActivity extends AppCompatActivity {

    private EditText id, name, password, cgpa;
    private RadioButton radioMale, radioFemale;
    private RadioGroup radioGroup;
    private Spinner collegeSpinner;
    private Button insertButton, backButton;
    private String gender = "";
    private StudentViewModel studentViewModel;
    private CollegeViewModel collegeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_student);

        id = findViewById(R.id.id_et);
        name = findViewById(R.id.name_et);
        radioMale = findViewById(R.id.radio_male);
        radioFemale = findViewById(R.id.radio_female);
        radioGroup = findViewById(R.id.radioGroup);
        collegeSpinner = findViewById(R.id.college_spinner);
        password = findViewById(R.id.password_et);
        cgpa = findViewById(R.id.cgpa_et);
        insertButton = findViewById(R.id.insertButton);
        backButton = findViewById(R.id.back_btn);

        collegeViewModel=ViewModelProviders.of(this).get(CollegeViewModel.class);

        collegeViewModel.getAllCollegeNames().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> colleges) {


                final ArrayAdapter<String> arrayAdapter = new ArrayAdapter(InsertStudentActivity.this, android.R.layout.simple_spinner_item, colleges);

                arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                collegeSpinner.setPrompt("Select College");

                collegeSpinner.setAdapter(arrayAdapter);

            }
        });








        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (radioMale.isChecked())
                    gender = "Male";
                else if (radioFemale.isChecked())
                    gender = "Female";

                if (id.getText().toString().isEmpty() || name.getText().toString().isEmpty() || cgpa.getText().toString().isEmpty() || password.getText().toString().isEmpty() || collegeSpinner.getSelectedItem().toString().isEmpty() || gender.isEmpty()) {
                    Toast.makeText(InsertStudentActivity.this, "Please Fill All Data", Toast.LENGTH_SHORT).show();
                } else {

                    saveStudent();

                    id.setText("");
                    name.setText("");
                    collegeSpinner.setSelection(0, false);
                    password.setText("");
                    cgpa.setText("");
                    radioGroup.clearCheck();
                }


            }
        });
    }

    private void saveStudent() {
        int mId = Integer.parseInt(id.getText().toString());
        String mName = name.getText().toString();
        Double mCGPA = Double.parseDouble(cgpa.getText().toString());
        String mPassword = password.getText().toString();
        String mCollege = collegeSpinner.getSelectedItem().toString();

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);
        studentViewModel.insert(new Student(mId,mName,mCGPA,mCollege,gender,mPassword));


        Toast.makeText(this, "Data Inserted", Toast.LENGTH_SHORT).show();


    }




}




