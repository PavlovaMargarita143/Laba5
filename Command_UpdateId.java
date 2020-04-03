package com.company;

import java.util.ArrayList;

public class Command_UpdateId implements Command {
    int id;
    City newCity;
    public Command_UpdateId(int id, City newCity){
        this.id= id;
        this.newCity = newCity;
    }
    @Override
    public void execute() {
        Reciver.update(A_Command.getSet(),this.id, newCity);
    }
}
