package ru.otus.homework.patternCommand.util;

import lombok.Data;

@Data
public class Point {

    private int coordinateX;

    private int coordinateY;

    public Point(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public Point moveTo(Vector velocity) {
        setCoordinateX(getCoordinateX() + velocity.getCoordinateDX());
        setCoordinateY(getCoordinateY() + velocity.getCoordinateDY());
        return this;
    }

}
