package com.kukuchta.diabetool.presentation.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kukuchta.diabetool.collectors.CollectorManager;
import com.kukuchta.diabetool.collectors.base.CollectorPlugin;
import com.kukuchta.diabetool.domain.usecase.GetSensorReadingsForPeriodUseCase;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private final GetSensorReadingsForPeriodUseCase getSensorReadingsUseCase;
    private final CollectorManager collectorManager;
    private final Timer collectorTimer = new Timer();
    private final MutableLiveData<String> mText;

    @Inject
    public MainViewModel(
            GetSensorReadingsForPeriodUseCase getSensorReadingsUseCase,
            CollectorManager collectorManager) {
        this.getSensorReadingsUseCase = getSensorReadingsUseCase;
        this.collectorManager = collectorManager;

        startDataCollection();

        mText = new MutableLiveData<>();
        mText.setValue("This is main fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    @Override
    protected void onCleared() {
        collectorTimer.cancel();
        super.onCleared();
    }

    private void startDataCollection() {
        collectorTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                collectorManager.collectDataFromActivePlugins();
            }
        }, 0, TimeUnit.MINUTES.toMillis(1)); //TODO Get collection period from preferences
    }
}