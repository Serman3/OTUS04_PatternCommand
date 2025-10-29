package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework.patternCommand.ex.CommandException;
import ru.otus.homework.patternCommand.model.FuelTank;

import static org.junit.jupiter.api.Assertions.*;

class CheckFuelCommandTest extends BaseTest {

    private FuelTank fuelTank;
    private Command checkFuelCommand;

    @BeforeEach
    public void setUp() {
        fuelTank = new FuelTank();
    }

    @Test
    public void checkFuelThrowExceptionTest() {
        fuelTank.setFuelAmount(0);
        checkFuelCommand = new CheckFuelCommand(fuelTank);
        assertThrows(CommandException.class, checkFuelCommand::execute);
    }

    @Test
    public void checkFuelNotThrowExceptionTest() {
        fuelTank.setFuelAmount(20);
        checkFuelCommand = new CheckFuelCommand(fuelTank);
        assertDoesNotThrow(checkFuelCommand::execute);
    }
}