package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.model.MovinObject;

public class MoveCommand implements Command {

    private final MovinObject movinObject;

    public MoveCommand(MovinObject movinObject) {
        this.movinObject = movinObject;
    }

    @Override
    public void execute() {
        movinObject.setLocation(
                movinObject.getLocation().moveTo(movinObject.getVelocity())
        );
    }
}
