package ru.otus.homework.patternCommand.command;

import ru.otus.homework.patternCommand.model.FuelTank;

public class BurnFuelCommand implements Command {

    private final FuelTank fuelTank;

    public BurnFuelCommand(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }

    @Override
    public void execute() {
        fuelTank.setFuelAmount(fuelTank.getFuelAmount() - fuelTank.getFuelConsumptionRate());
    }
}
