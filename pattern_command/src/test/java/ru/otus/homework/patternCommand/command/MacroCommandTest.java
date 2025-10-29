package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.otus.homework.patternCommand.ex.CommandException;
import ru.otus.homework.patternCommand.model.FuelTank;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MacroCommandTest extends BaseTest {

    private FuelTank fuelTank;
    private Command checkFuelCommand;
    private Command moveCommandMock;
    private Command burnFuelCommand;
    private Command macroCommand;
    private final List<Command> commandList = new LinkedList<>();

    @BeforeEach
    void setUp() {
        moveCommandMock = Mockito.mock(Command.class);
    }

    @Test
    public void macroCommandThrowExceptionTest() {
        fuelTank = new FuelTank(0.0, 3.0);

        checkFuelCommand = new CheckFuelCommand(fuelTank);
        burnFuelCommand = new BurnFuelCommand(fuelTank);

        commandList.add(checkFuelCommand);
        commandList.add(moveCommandMock);
        commandList.add(burnFuelCommand);

        macroCommand = new MacroCommand(commandList);

        assertThrows(CommandException.class, macroCommand::execute);
    }

    @Test
    public void macroCommandNotThrowExceptionTest() {
        fuelTank = new FuelTank(10.0, 3.0);

        checkFuelCommand = new CheckFuelCommand(fuelTank);
        burnFuelCommand = new BurnFuelCommand(fuelTank);

        commandList.add(checkFuelCommand);
        commandList.add(moveCommandMock);
        commandList.add(burnFuelCommand);

        macroCommand = new MacroCommand(commandList);

        assertDoesNotThrow(macroCommand::execute);
    }
}