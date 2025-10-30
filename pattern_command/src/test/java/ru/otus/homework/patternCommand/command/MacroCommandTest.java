package ru.otus.homework.patternCommand.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.otus.homework.patternCommand.ex.CommandException;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MacroCommandTest extends BaseTest {

    private Command checkFuelCommandMock;
    private Command moveCommandMock;
    private Command burnFuelCommand;
    private Command macroCommand;
    private final List<Command> commandList = new LinkedList<>();

    @BeforeEach
    void setUp() {
        checkFuelCommandMock = mock(Command.class);
        moveCommandMock = mock(Command.class);
        burnFuelCommand = mock(Command.class);

        commandList.add(checkFuelCommandMock);
        commandList.add(moveCommandMock);
        commandList.add(burnFuelCommand);

        macroCommand = new MacroCommand(commandList);
    }

    @Test
    public void macroCommandThrowExceptionTest() {
        doThrow(CommandException.class).when(moveCommandMock).execute();

        assertThrows(CommandException.class, macroCommand::execute);
        verify(checkFuelCommandMock).execute();
        verify(moveCommandMock).execute();
        verify(burnFuelCommand, never()).execute();
    }

    @Test
    public void macroCommandNotThrowExceptionTest() {
        assertDoesNotThrow(macroCommand::execute);
        verify(checkFuelCommandMock).execute();
        verify(moveCommandMock).execute();
        verify(burnFuelCommand).execute();
    }
}