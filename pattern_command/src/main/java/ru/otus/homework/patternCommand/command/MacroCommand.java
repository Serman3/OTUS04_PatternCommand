package ru.otus.homework.patternCommand.command;

import java.util.List;

public class MacroCommand implements Command {

    private final List<Command> commandList;

    public MacroCommand(List<Command> commandList) {
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        for (Command command : commandList) {
            command.execute();
        }
    }
}
