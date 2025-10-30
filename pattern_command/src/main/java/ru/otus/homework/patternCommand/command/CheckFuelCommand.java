package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.ex.CommandException;
import ru.otus.homework.patternCommand.model.BurnFuelingObject;

public class CheckFuelCommand implements Command {

    private final BurnFuelingObject burnFuelingObject;

    public CheckFuelCommand(BurnFuelingObject burnFuelingObject) {
        this.burnFuelingObject = burnFuelingObject;
    }

    @Override
    public void execute() {
        if (Double.compare(0, burnFuelingObject.getFuelAmount()) >= 0) throw new CommandException("Not enough fuel");
    }
}
