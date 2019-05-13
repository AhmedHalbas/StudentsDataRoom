package com.example.android.studentsdataroom.Data;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.android.studentsdataroom.Model.Student;
import com.example.android.studentsdataroom.R;
import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    private List<Student> students = new ArrayList<>();

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_student_item_students, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Student currentStudent = students.get(position);
        holder.id.setText("ID: "+currentStudent.getId()+"");
        holder.name.setText("Name: "+currentStudent.getName());
        holder.cgpa.setText("CGPA: "+currentStudent.getCGPA().toString());
        holder.college.setText("College: "+currentStudent.getCollege());
        holder.gender.setText("Gender: "+currentStudent.getGender());
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public void setStudents(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView id, name, cgpa, college, gender;

        public Holder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.id_tv);
            name = itemView.findViewById(R.id.name_tv);
            cgpa = itemView.findViewById(R.id.cgpa_tv);
            college = itemView.findViewById(R.id.college_tv);
            gender = itemView.findViewById(R.id.gender_tv);
        }
    }
}