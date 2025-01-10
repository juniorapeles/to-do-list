package com.junior.taskapp.entities.enums;

public enum Status {
    TO_DO(1),
    IN_PROGRESS(2),
    COMPLETED(3),
    CANCELLED(4);

    private final int value;


    private Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Status getStatus(int value) {
        for (Status status : Status.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status: " + value);
    }
}
