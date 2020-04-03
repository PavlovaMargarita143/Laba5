package com.company;

import java.io.File;
import java.io.IOException;

public class Command_Script implements  Command {
    public File file;

    public Command_Script(File file){
        this.file = file;
    }
    @Override
    public void execute() {
        try {
            Reciver.script(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
