package model;

import java.util.Arrays;

public enum Status {
    CREATED("СОЗДАН"), EXECUTED("ИСПОЛНЕН");

    private final String text;
    Status(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Status getByText(String text) {
        return Arrays.stream(Status.values())
                .filter(status -> text.equalsIgnoreCase(status.getText()))
                .findFirst()
                .orElse(null);
    }
}
