package com.yuchen.spring.demo.controller;

public class EliteNotFoundException extends RuntimeException {
    public EliteNotFoundException(String message) {
        super(message);
    }
}
