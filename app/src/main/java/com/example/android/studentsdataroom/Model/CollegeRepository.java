package com.example.android.studentsdataroom.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class CollegeRepository {

    private CollegeDao collegeDao;
    private LiveData<List<String>> allCollegeNames;


    public CollegeRepository(Application application) {
        MyDatabase database = MyDatabase.getInstance(application);
        collegeDao = database.collegeDao();
        allCollegeNames=collegeDao.getAllColleges();
    }

    public void insert(College college) {
        new InsertCollegeAsyncTask(collegeDao).execute(college);
    }

    public void update(College college) {
        new UpdateCollegeAsyncTask(collegeDao).execute(college);
    }

    public void delete(College college) {
        new DeleteCollegeAsyncTask(collegeDao).execute(college);
    }

    public LiveData<List<String>> getAllCollegeNames() {
        return allCollegeNames;
    }



    private static class InsertCollegeAsyncTask extends AsyncTask<College, Void, Void> {
        private CollegeDao collegeDao;

        private InsertCollegeAsyncTask(CollegeDao collegeDao) {
            this.collegeDao = collegeDao;
        }

        @Override
        protected Void doInBackground(College... colleges) {
            collegeDao.insert(colleges[0]);
            return null;
        }
    }

    private static class UpdateCollegeAsyncTask extends AsyncTask<College, Void, Void> {
        private CollegeDao collegeDao;

        private UpdateCollegeAsyncTask(CollegeDao collegeDao) {
            this.collegeDao = collegeDao;
        }

        @Override
        protected Void doInBackground(College... colleges) {
            collegeDao.update(colleges[0]);
            return null;
        }
    }

    private static class DeleteCollegeAsyncTask extends AsyncTask<College, Void, Void> {
        private CollegeDao collegeDao;

        private DeleteCollegeAsyncTask(CollegeDao collegeDao) {
            this.collegeDao = collegeDao;
        }

        @Override
        protected Void doInBackground(College... colleges) {
            collegeDao.delete(colleges[0]);
            return null;
        }
    }


}
