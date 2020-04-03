package com.company;

//import java.io.IOException;

class Invoker {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand()  {
        this.command.execute();
    }
}
