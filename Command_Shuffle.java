package com.company;

import java.util.ArrayList;

public class Command_Shuffle implements Command {


    public Command_Shuffle( ){

    }
    @Override
    public void execute() {
        Reciver.shuffle(A_Command.getSet());

    }
}
