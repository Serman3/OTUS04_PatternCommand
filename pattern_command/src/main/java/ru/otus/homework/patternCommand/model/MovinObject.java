package ru.otus.homework.patternCommand.model;

import ru.otus.homework.patternCommand.util.Point;
import ru.otus.homework.patternCommand.util.Vector;

public interface MovinObject {

    Point getLocation();

    Vector getVelocity();

    void setLocation(Point newPoint);
}
