package com.example.android.studentsdataroom.Data;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.android.studentsdataroom.Model.Student;
import com.example.android.studentsdataroom.Model.StudentViewModel;
import com.example.android.studentsdataroom.R;

import java.util.List;

public class ViewStudentsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private StudentViewModel studentViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view_students);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));



        final MyAdapter adapter= new MyAdapter();
        recyclerView.setAdapter(adapter);


        studentViewModel = ViewModelProviders.of(this).get(StudentViewModel.class);

        studentViewModel.getAllStudents().observe(this, new Observer<List<Student>>() {
            @Override
            public void onChanged(@Nullable List<Student> students) {

              adapter.setStudents(students);

            }
        });






    }


}

