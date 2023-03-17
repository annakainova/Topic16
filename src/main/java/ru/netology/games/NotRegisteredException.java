package ru.netology.games;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String message) {
        super(message);
    }
}
