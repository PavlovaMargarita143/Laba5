package com.company;

public class Command_RemoveById implements Command {
    int id;
    public Command_RemoveById (int id){
        this.id =id;
    }
    @Override
    public void execute() {
Reciver.removeById(A_Command.getSet(),id);
    }
}
