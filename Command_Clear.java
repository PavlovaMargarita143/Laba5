package com.company;

import java.util.ArrayList;

public class Command_Clear implements Command {


    public Command_Clear( ){

    }
    @Override
    public void execute() {
        Reciver.clear( A_Command.getSet());

    }
}
