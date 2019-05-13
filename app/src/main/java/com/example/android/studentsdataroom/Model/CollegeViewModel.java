package com.example.android.studentsdataroom.Model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class CollegeViewModel extends AndroidViewModel {

    private CollegeRepository collegeRepository;

    private LiveData<List<String>> allCollegeNames;


    public CollegeViewModel(@NonNull Application application) {
        super(application);
        collegeRepository = new CollegeRepository(application);
        allCollegeNames= collegeRepository.getAllCollegeNames();

    }

    public void insert(College college) {
        collegeRepository.insert(college);
    }

    public void update(College college) {
        collegeRepository.update(college);
    }

    public void delete(College college) {
        collegeRepository.delete(college);
    }


    public LiveData<List<String>> getAllCollegeNames() {
        return allCollegeNames;
    }


}