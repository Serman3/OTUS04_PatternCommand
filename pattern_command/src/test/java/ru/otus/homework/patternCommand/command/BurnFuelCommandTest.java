package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework.patternCommand.model.FuelTank;

import static org.junit.jupiter.api.Assertions.*;

class BurnFuelCommandTest extends BaseTest {

    private FuelTank fuelTank;
    private Command burnFuelCommand;

    @BeforeEach
    public void setUp() {
        fuelTank = new FuelTank(10.0, 3.0);
        burnFuelCommand = new BurnFuelCommand(fuelTank);
    }

    @Test
    public void reduceAmountFuelTest() {
        burnFuelCommand.execute();
        assertEquals(7.0, fuelTank.getFuelAmount());
    }
}