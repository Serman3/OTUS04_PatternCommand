package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.ex.CommandException;
import ru.otus.homework.patternCommand.model.FuelTank;

public class CheckFuelCommand implements Command {

    private final FuelTank fuelTank;

    public CheckFuelCommand(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    @Override
    public void execute() {
        if (Double.compare(0, fuelTank.getFuelAmount()) >= 0) throw new CommandException("Not enough fuel");
    }
}
