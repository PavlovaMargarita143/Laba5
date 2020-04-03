package com.company;

public class Command_AverageOfAgglomeration implements  Command {
    public  Command_AverageOfAgglomeration(){}
    @Override
    public void execute() {
        Reciver.averageOfAgg(A_Command.getSet());
    }
}
