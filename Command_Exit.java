package com.company;

public class Command_Exit implements Command {
    public Command_Exit(){

    }
    @Override
    public void execute() {
        Reciver.exit();
    }
}
