package com.example.android.studentsdataroom.Model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Student.class,College.class}, version = 2)

public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase instance;

    public abstract StudentDao studentDao();

    public abstract CollegeDao collegeDao();

    public static synchronized MyDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyDatabase.class, "database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CollegeDao collegeDao;

        private PopulateDbAsyncTask(MyDatabase db) {
            collegeDao = db.collegeDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            collegeDao.insert(new College("IT"));
            collegeDao.insert(new College("Engineering"));
            collegeDao.insert(new College("MC"));
            collegeDao.insert(new College("Medicine"));
            collegeDao.insert(new College("Fine Arts"));
            collegeDao.insert(new College("Law"));

            return null;
        }


    }

}