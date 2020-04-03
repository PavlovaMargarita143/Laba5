package com.company;

public class Command_Error implements Command {
    public Command_Error(){}
    @Override
    public void execute(){
        Reciver.error();
    }
}
