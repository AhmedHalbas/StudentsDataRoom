package com.example.android.studentsdataroom.Model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {

    private StudentRepository studentRepository;
    private LiveData<List<Student>> allStudents;
    private LiveData<List<String>> allStudentNames;
    private LiveData<List<String>> allStudentPasswords;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        studentRepository = new StudentRepository(application);
        allStudents = studentRepository.getAllStudents();
        allStudentNames= studentRepository.getAllStudentNames();
        allStudentPasswords= studentRepository.getAllStudentPasswords();
    }

    public void insert(Student student) {
        studentRepository.insert(student);
    }

    public void update(Student student) {
        studentRepository.update(student);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public void deleteAllStudents() {
        studentRepository.deleteAllStudents();
    }

    public LiveData<List<Student>> getAllStudents() {
        return allStudents;
    }

    public LiveData<List<String>> getAllStudentNames() {
        return allStudentNames;
    }

    public LiveData<List<String>> getAllStudentPasswords() {
        return allStudentPasswords;
    }
}

