package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.model.RotatingObject;

public class ChangeVelocityRotatingCommand implements Command {

    private final RotatingObject rotatingObject;
    private final int angularVelocity;

    public ChangeVelocityRotatingCommand(RotatingObject rotatingObject, int angularVelocity) {
        this.rotatingObject = rotatingObject;
        this.angularVelocity = angularVelocity;
    }

    @Override
    public void execute() {
        rotatingObject.setAngularVelocity(angularVelocity);
        new RotateCommand(rotatingObject).execute();
    }
}
