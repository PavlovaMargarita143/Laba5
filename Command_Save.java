package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class Command_Save implements Command {


    public Command_Save( ){

    }
    @Override
    public void execute() {
        try {
            Reciver.save(A_Command.getSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
