package com.kukuchta.diabetool.presentation.backup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class BackupViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    @Inject
    public BackupViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is backup fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}