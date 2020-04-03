package com.company;

public class Command_MaxCoordinates implements Command {
    public Command_MaxCoordinates(){}
    @Override
    public void execute() {
        Reciver.maxCoordinates(A_Command.getSet());

    }
}
