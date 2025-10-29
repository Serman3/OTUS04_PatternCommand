package ru.otus.homework.patternCommand.model;

public class FuelTank {

    private double fuelAmount;

    private double fuelConsumptionRate;

    public FuelTank() {};

    public FuelTank(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public FuelTank(double fuelAmount, double fuelConsumptionRate) {
        this.fuelAmount = fuelAmount;
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void setFuelConsumptionRate(double fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }
}
