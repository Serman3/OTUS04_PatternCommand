package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.model.RotatingObject;

public class RotateCommand implements Command {

    private final RotatingObject rotatingObject;

    public RotateCommand(RotatingObject rotatingObject) {
        this.rotatingObject = rotatingObject;
    }

    @Override
    public void execute() {
        rotatingObject.setDirection(
                (rotatingObject.getDirection() + rotatingObject.getAngularVelocity()) % rotatingObject.getDirectionsNumber()
        );
    }
}
