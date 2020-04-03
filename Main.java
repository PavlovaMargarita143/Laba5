package com.company;


import com.google.gson.Gson;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class Main {


    public static void main(String[] args) throws IOException{
            for (String str : args)
    { FileReader Fr = new FileReader(str);
        BufferedReader f = new BufferedReader(Fr);
        String line =null;
        Reader reader = new Reader();
        line=f.readLine();
        ArrayList<City> collection = new ArrayList<City>();
         while (line!= null){
               try {City newCity= new Gson().fromJson(line,City.class);

              collection.add( newCity);
              line = f.readLine();}
               catch (com.google.gson.JsonSyntaxException e){
                   System.out.println("Некоректные данные в файле!!! Программа завершена, исправьте или очистите файл и запустите программу заново");
                   System.exit(0);
               }
            }


        Invoker invoker = new Invoker();
        A_Command.setSet(collection);




     while (true){
         System.out.println("Введите команду, чтобы посмотреть доступные команды, введите Help");
         invoker.setCommand(reader.ReadCommand());
     }



    }

}}

