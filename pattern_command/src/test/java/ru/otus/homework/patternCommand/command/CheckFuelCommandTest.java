package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework.patternCommand.ex.CommandException;
import ru.otus.homework.patternCommand.model.BurnFuelingObject;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CheckFuelCommandTest extends BaseTest {

    private Command checkFuelCommand;
    private BurnFuelingObject burnFuelingObject;

    @BeforeEach
    public void setUp() {
        burnFuelingObject = mock(BurnFuelingObject.class);
    }

    @Test
    public void checkFuelThrowExceptionTest() {
        when(burnFuelingObject.getFuelAmount()).thenReturn(0.0);
        checkFuelCommand = new CheckFuelCommand(burnFuelingObject);
        assertThrows(CommandException.class, checkFuelCommand::execute);
    }

    @Test
    public void checkFuelNotThrowExceptionTest() {
        when(burnFuelingObject.getFuelAmount()).thenReturn(20.0);
        checkFuelCommand = new CheckFuelCommand(burnFuelingObject);
        assertDoesNotThrow(checkFuelCommand::execute);
    }
}