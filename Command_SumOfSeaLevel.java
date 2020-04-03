package com.company;

public class Command_SumOfSeaLevel implements Command {
    public Command_SumOfSeaLevel(){}
    @Override
    public void execute() {
        Reciver.sumOfSeaL(A_Command.getSet());
    }
}
