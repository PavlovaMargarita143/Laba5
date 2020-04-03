package com.company;

import java.util.ArrayList;

class Command_RemoveAt implements Command{
    ArrayList<City> set;
    int index;
    Command_RemoveAt(int index){
        this.index=index;
    }

    @Override
    public void execute() {
        Reciver.remove(A_Command.getSet(),this.index);
    }
}

