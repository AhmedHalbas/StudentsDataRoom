package com.example.android.studentsdataroom.Data;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.studentsdataroom.Model.College;
import com.example.android.studentsdataroom.Model.CollegeDao;
import com.example.android.studentsdataroom.Model.Student;
import com.example.android.studentsdataroom.Model.StudentViewModel;
import com.example.android.studentsdataroom.R;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText loginUsername,loginPassword;

    private Button login;

   private boolean loginData=false;

   private StudentViewModel studentViewModel;
   private List<String> names =  new ArrayList<>();
   private List<String> passwords=new ArrayList<>();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginUsername=findViewById(R.id.login_username_et);
        loginPassword=findViewById(R.id.login_password_et);
        login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginCheck();

                if( (loginUsername.getText().toString().equals("Admin") && loginPassword.getText().toString().equals("Admin")) || loginData )
                {
                    Intent intent = new Intent(LoginActivity.this,WelcomeActivity.class);

                    String userName = loginUsername.getText().toString();

                    Bundle b = new Bundle();
                    b.putString("userName",userName);
                    intent.putExtras(b);

                    startActivity(intent);

                   loginUsername.setText("");
                   loginPassword.setText("");
                }

                else
                {
                    Toast.makeText(LoginActivity.this, "ERROR : WRONG LOGIN DATA", Toast.LENGTH_SHORT).show();

                    loginUsername.setText("");
                    loginPassword.setText("");
                }


            }
        });

    }


    private void loginCheck()
    {

        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        studentViewModel.getAllStudentNames().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> studentnames) {

                names.addAll(studentnames);


            }
        });


        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        studentViewModel.getAllStudentPasswords().observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> studentpasswords) {

                passwords.addAll(studentpasswords);


            }
        });




        for(int i=0 ; i<names.size() ; i++)
        {

            if(loginUsername.getText().toString().equals(names.get(i)) && loginPassword.getText().toString().equals(passwords.get(i)))
            {

                loginData=true;

                return;
            }


            loginData=false;



        }




    }








}
