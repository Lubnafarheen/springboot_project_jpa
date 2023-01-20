package com.lubna.springboot_project_jpa.exception;

public class DataNotFoundException extends Throwable {
    public DataNotFoundException(String message) {
        super(message);
    }
}
