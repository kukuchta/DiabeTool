package com.kukuchta.diabetool.presentation.status;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class StatusViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    @Inject
    public StatusViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is status fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}