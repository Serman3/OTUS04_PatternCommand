package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.model.BurnFuelingObject;
import ru.otus.homework.patternCommand.model.MovinObject;

import java.util.List;

public class MoveBurnFuelMacroCommand implements Command {

    private final List<Command> commandList;

    public MoveBurnFuelMacroCommand(MovinObject movinObject, BurnFuelingObject burnFuelingObject) {
        this.commandList = List.of(new MoveCommand(movinObject), new BurnFuelCommand(burnFuelingObject));
    }

    @Override
    public void execute() {
        for (Command command : this.commandList) {
            command.execute();
        }
    }
}
