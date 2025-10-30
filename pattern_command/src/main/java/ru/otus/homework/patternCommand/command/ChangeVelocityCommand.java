package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.model.MovingRotatingObject;
import ru.otus.homework.patternCommand.model.RotatingObject;

import java.util.LinkedList;
import java.util.List;

public class ChangeVelocityCommand implements Command {

    private final List<Command> commandList = new LinkedList<>();

    public ChangeVelocityCommand(MovingRotatingObject movingRotatingObject, int angularVelocity) {
        RotatingObject rotatingObject = movingRotatingObject.getRotatingObject();
        rotatingObject.setAngularVelocity(angularVelocity);
        commandList.add(new RotateCommand(rotatingObject));
        if (movingRotatingObject.getMovingObject() != null) {
            commandList.add(new MoveCommand(movingRotatingObject.getMovingObject()));
        }
    }

    @Override
    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }

}
