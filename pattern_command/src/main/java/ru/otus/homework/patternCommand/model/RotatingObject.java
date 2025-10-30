package ru.otus.homework.patternCommand.model;

public interface RotatingObject {

    int getDirection();

    void setDirection(int newDirection);

    void setAngularVelocity(int angularVelocity);

    int getAngularVelocity();

    int getDirectionsNumber();
}
