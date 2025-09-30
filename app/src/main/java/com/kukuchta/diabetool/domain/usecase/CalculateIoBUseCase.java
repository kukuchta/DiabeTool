package com.kukuchta.diabetool.domain.usecase;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData; // Or custom calculation
import com.kukuchta.diabetool.domain.model.IoB;
import com.kukuchta.diabetool.domain.model.Bolus;
// import com.kukuchta.diabetool.domain.model.InsulinSensitivityFactor; // Assuming you have these
// import com.kukuchta.diabetool.domain.model.DurationOfInsulinAction; // Assuming you have these
import com.kukuchta.diabetool.domain.repository.BolusRepository;
// import com.kukuchta.diabetool.domain.repository.SettingsRepository; // To get ISF, DIA

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalculateIoBUseCase {
    private final BolusRepository bolusRepository;
    // private final SettingsRepository settingsRepository; // For ISF, DIA

    // Default DIA if not fetched from settings (e.g., 4 hours)
    private static final long DEFAULT_DIA_MILLIS = TimeUnit.HOURS.toMillis(4);


    public CalculateIoBUseCase(@NonNull BolusRepository bolusRepository /*, @NonNull SettingsRepository settingsRepository */) {
        this.bolusRepository = bolusRepository;
        // this.settingsRepository = settingsRepository;
    }

    // This is a simplified example. Real IOB calculation can be complex.
    // It might involve observing multiple LiveData sources (boluses, settings)
    // and recalculating. A MediatorLiveData or combining Flows (if using Kotlin Flow)
    // would be more robust for dynamic updates.
    // For now, let's assume it calculates based on current boluses when called.
    @NonNull
    public LiveData<IoB> execute() {
        // This is a placeholder for a more complex calculation.
        // A proper implementation would:
        // 1. Fetch relevant recent boluses (e.g., within DIA).
        // 2. Fetch Duration of Insulin Action (DIA) from settings.
        // 3. For each bolus, calculate its remaining activity based on DIA and time elapsed.
        //    (e.g., linear decay, or more complex insulin curve models).
        // 4. Sum up the remaining activity from all relevant boluses.
        // 5. Return as LiveData<IoB>.

        // For simplicity, this example will just return a LiveData that attempts
        // to calculate once based on the latest bolus when this LiveData is first observed.
        // This is NOT ideal for continuous IOB.
        // Consider using MediatorLiveData to observe bolusRepository.getBoluses(...)
        // and settingsRepository.getDurationOfInsulinAction() and recalculate.

        MediatorLiveData<IoB> iobLiveData = new MediatorLiveData<>();

        // Example: Get boluses from the last DIA period
        Date now = new Date();
        Date startTime = new Date(now.getTime() - DEFAULT_DIA_MILLIS); // Simplified DIA

        LiveData<List<Bolus>> recentBolusesLiveData = bolusRepository.getBoluses(startTime, now);

        iobLiveData.addSource(recentBolusesLiveData, recentBoluses -> {
            double totalIob = 0.0;
            if (recentBoluses != null) {
                for (Bolus bolus : recentBoluses) {
                    long timeElapsedMillis = now.getTime() - bolus.getTimestamp().getTime();
                    if (timeElapsedMillis < DEFAULT_DIA_MILLIS) {
                        // Simplified linear decay for example purposes
                        double fractionRemaining = 1.0 - ((double) timeElapsedMillis / DEFAULT_DIA_MILLIS);
                        totalIob += bolus.getUnits() * fractionRemaining;
                    }
                }
            }
            // Ensure IOB is not negative
            if (totalIob < 0) totalIob = 0.0;
            iobLiveData.setValue(new IoB(new Date(), totalIob));
        });

        return iobLiveData;
        // A more robust solution might involve a service or a more complex reactive stream.
    }
}
