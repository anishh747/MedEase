package com.example.medease.ui.find_a_doctor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FindADoctorViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FindADoctorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is find A Doctor fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}