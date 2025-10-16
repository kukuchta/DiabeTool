package com.kukuchta.diabetool.collectors.plugins;

import androidx.annotation.NonNull;
import com.kukuchta.diabetool.collectors.base.CollectorPlugin;
import com.kukuchta.diabetool.domain.model.SensorReading;
import com.kukuchta.diabetool.domain.repository.SensorReadingRepository;
import com.kukuchta.diabetool.domain.usecase.LogSensorReadingUseCase;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class TestCollectorPlugin implements CollectorPlugin {
    private static final int READING_INTERVAL_MINUTES = 5;
    private static final int INITIAL_GLUCOSE_VALUE = 120;
    private static final int MIN_GLUCOSE = 40;
    private static final int MAX_GLUCOSE = 300;

    private final LogSensorReadingUseCase logSensorReadingUseCase;
    private final SensorReadingRepository sensorReadingRepository;
    private final Random random = new Random();
    private final Executor backgroundExecutor = Executors.newSingleThreadExecutor();

    @Inject
    public TestCollectorPlugin(@NonNull LogSensorReadingUseCase logSensorReadingUseCase, @NonNull SensorReadingRepository sensorReadingRepository) {
        this.logSensorReadingUseCase = logSensorReadingUseCase;
        this.sensorReadingRepository = sensorReadingRepository;
    }

    @Override
    public void collectData() {
        backgroundExecutor.execute(this::generateAndSaveReadings);
    }

    private void generateAndSaveReadings() {
        SensorReading lastReading = sensorReadingRepository.getLatestSensorReading();

        Date lastReadingDate;
        int lastValue;

        if (lastReading != null) {
            lastReadingDate = lastReading.getTimestamp();
            lastValue = lastReading.getValue();
        } else {
            lastReadingDate = getInitialStartDate();
            lastValue = INITIAL_GLUCOSE_VALUE;
        }

        Date now = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastReadingDate);

        while (true) {
            calendar.add(Calendar.MINUTE, READING_INTERVAL_MINUTES);
            Date nextReadingTime = calendar.getTime();
            if (nextReadingTime.after(now)) {
                break;
            }

            int change = random.nextInt(21) - 10;
            int newValue = Math.max(MIN_GLUCOSE, Math.min(MAX_GLUCOSE, lastValue + change));

            SensorReading newReading = new SensorReading(nextReadingTime, newValue);
            logSensorReadingUseCase.execute(newReading);

            lastValue = newValue;
        }
    }

    /*     * Calculates an initial start date that is guaranteed to be in the past.
     * It finds the last 5-minute mark and then subtracts another 5 minutes.
     * For example, if it's 13:08, the last mark is 13:05. This function will
     * return 13:00, ensuring at least one reading (for 13:05) is generated.
     */
    private Date getInitialStartDate() {
        Calendar calendar = Calendar.getInstance();
        int minutes = calendar.get(Calendar.MINUTE);
        int remainder = minutes % READING_INTERVAL_MINUTES;

        // Go back to the most recent 5-minute mark (e.g., 13:08 -> 13:05)
        calendar.add(Calendar.MINUTE, -remainder);

        // THEN, go back one more full interval to ensure it's in the past. (13:05 -> 13:00)
        calendar.add(Calendar.MINUTE, -READING_INTERVAL_MINUTES);

        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
