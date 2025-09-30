package com.kukuchta.diabetool.domain.model;

import androidx.annotation.NonNull;

import java.util.Date;
import java.util.Objects;

public class Notification {
    private final Date timestamp;
    private final NotificationType type;
    private final String message;
    private final boolean isManualEntry;

    public Notification(Date timestamp, NotificationType type, String message, boolean isManualEntry) {
        this.timestamp = timestamp;
        this.type = type;
        this.message = message;
        this.isManualEntry = isManualEntry;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public NotificationType getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public boolean isManualEntry() {
        return isManualEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return isManualEntry == that.isManualEntry &&
                Objects.equals(timestamp, that.timestamp) &&
                type == that.type &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, type, message, isManualEntry);
    }

    @NonNull
    @Override
    public String toString() {
        return "Notification{" +
                "timestamp=" + timestamp +
                ", type=" + type +
                ", message='" + message +
                ", isManualEntry=" + isManualEntry +
                '}';
    }
}
