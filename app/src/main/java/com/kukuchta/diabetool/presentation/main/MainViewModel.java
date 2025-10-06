package com.kukuchta.diabetool.presentation.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kukuchta.diabetool.domain.usecase.GetSensorReadingsForPeriodUseCase;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final GetSensorReadingsForPeriodUseCase getSensorReadingsUseCase;
    private final MutableLiveData<String> mText;

    @Inject
    public MainViewModel(GetSensorReadingsForPeriodUseCase getSensorReadingsUseCase) {
        this.getSensorReadingsUseCase = getSensorReadingsUseCase;
        mText = new MutableLiveData<>();
        mText.setValue("This is main fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}