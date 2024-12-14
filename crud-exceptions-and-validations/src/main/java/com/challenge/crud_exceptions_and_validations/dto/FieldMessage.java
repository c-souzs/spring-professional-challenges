package com.challenge.crud_exceptions_and_validations.dto;

public class FieldMessage {
    private String name, message;

    public FieldMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
