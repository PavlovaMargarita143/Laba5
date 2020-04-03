package com.company;

import java.util.ArrayList;

class Command_Add implements Command{

    City newCity;
    public Command_Add( City newCity){

        this.newCity=newCity;
    }

    @Override
    public void execute() {
        Reciver.add(newCity,A_Command.getSet());
    }
}
