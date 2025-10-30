package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.model.BurnFuelingObject;

public class BurnFuelCommand implements Command {

    private final BurnFuelingObject burnFuelingObject;

    public BurnFuelCommand(BurnFuelingObject burnFuelingObject) {
        this.burnFuelingObject = burnFuelingObject;
    }

    @Override
    public void execute() {
        burnFuelingObject.setFuelAmount(burnFuelingObject.getFuelAmount() - burnFuelingObject.getFuelConsumptionRate());
    }
}
