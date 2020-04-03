package com.company;

public class Command_Sort implements Command {
    public  Command_Sort(){}
    @Override
    public void execute() {
        Reciver.sort(A_Command.getSet());
    }
}
