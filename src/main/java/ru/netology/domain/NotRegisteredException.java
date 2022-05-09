package ru.netology.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String name) {
        super(" Player " + name + " isn't registered. He can't take part at the Tournament.");
    }
}

