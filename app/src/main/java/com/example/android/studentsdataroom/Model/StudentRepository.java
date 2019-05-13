package com.example.android.studentsdataroom.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class StudentRepository {

    private StudentDao studentDao;
    private LiveData<List<Student>> allStudents;
    private LiveData<List<String>> allStudentNames;
    private LiveData<List<String>> allStudentPasswords;

    public StudentRepository(Application application) {
        MyDatabase database = MyDatabase.getInstance(application);
        studentDao = database.studentDao();
        allStudents = studentDao.getAllStudents();
        allStudentNames=studentDao.getAllStudentNames();
        allStudentPasswords=studentDao.getAllStudentPasswords();
    }

    public void insert(Student student) {
        new InsertStudentAsyncTask(studentDao).execute(student);
    }

    public void update(Student student) {
        new UpdateStudentAsyncTask(studentDao).execute(student);
    }

    public void delete(Student student) {
        new DeleteStudentAsyncTask(studentDao).execute(student);
    }

    public void deleteAllStudents() {
        new DeleteAllStudentsAsyncTask(studentDao).execute();
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

    private static class InsertStudentAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        private InsertStudentAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.insert(students[0]);
            return null;
        }
    }

    private static class UpdateStudentAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        private UpdateStudentAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.update(students[0]);
            return null;
        }
    }

    private static class DeleteStudentAsyncTask extends AsyncTask<Student, Void, Void> {
        private StudentDao studentDao;

        private DeleteStudentAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Student... students) {
            studentDao.delete(students[0]);
            return null;
        }
    }

    private static class DeleteAllStudentsAsyncTask extends AsyncTask<Void, Void, Void> {
        private StudentDao studentDao;

        private DeleteAllStudentsAsyncTask(StudentDao studentDao) {
            this.studentDao = studentDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            studentDao.deleteAllStudents();
            return null;
        }
    }
}
