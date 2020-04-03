package com.company;

public class Command_Help implements  Command {
    public void Command_Help(){

    }
    @Override
    public void execute() { Reciver.help();
    }
}
