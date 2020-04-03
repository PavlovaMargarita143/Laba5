package com.company;

import java.util.ArrayList;

public class Command_Show implements Command {


    public Command_Show( ){

    }
    @Override
    public void execute() {
        Reciver.show(A_Command.getSet());

    }
}
