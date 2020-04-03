package com.company;

public class Command_Info implements Command {
    public  Command_Info(){}

    @Override
    public void execute() {
        Reciver.info(A_Command.getSet());

    }
}
