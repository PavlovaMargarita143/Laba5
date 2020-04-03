package com.company;



import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

class Reciver{

    public static void add(City newCity, ArrayList<City> collection){
      collection.add(newCity);
    }
    public  static void remove(ArrayList<City> collection,int index){
         collection.remove(index);
    }

    public static  void  help(){
        System.out.println ("Вы можете использовать следующие команды:");
        System.out.println ("Info : вывести в стандартный поток вывода информацию о коллекции ");
        System.out.println ("Show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println ("Add : добавить новый элемент в коллекцию");
        System.out.println ("UpdateId : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println ("RemoveById : удалить элемент из коллекции по его id");
        System.out.println ("Clear : очистить коллекцию");
        System.out.println ("Save : сохранить коллекцию в файл");
        System.out.println ("Script : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println ("Exit : завершить программу (без сохранения в файл)");
        System.out.println ("RemoveAt : удалить элемент, находящийся в заданной позиции коллекции (index)");
        System.out.println ("Shuffle : перемешать элементы коллекции в случайном порядке");
        System.out.println ("Sort : отсортировать коллекцию в естественном порядке");
        System.out.println ("SumOfSeaLevel : вывести сумму значений поля metersAboveSeaLevel для всех элементов коллекции");
        System.out.println (" AverageOfAgg : вывести среднее значение поля agglomeration для всех элементов коллекции");
        System.out.println (" MaxCoordinates : вывести любой объект из коллекции, значение поля coordinates которого является максимальным");

    }
    public static void clear(ArrayList<City> collection){
       collection.clear();
    }
    public  static  void  error(){
        System.out.println("Вы неправильно ввели команду, попробуйте еще раз");


    }
    public static void exit(){
        System.out.println("Программа завершена, несохраненные данные утеряны");
        System.exit(0);

    }
    public static void  show(ArrayList<City> collection){
        System.out.println(collection.toString());
    }
    public static void shuffle(ArrayList<City> collection){
        Collections.shuffle(collection);
    }
    public static void sort(ArrayList<City> collection){
        collection.sort(City::compareTo);
    }
    public static void removeById (ArrayList<City> collection,int id){
        int b =1;
        for (int i = 0; i < collection.size(); i++){
            b++;
            if (Objects.equals(Integer.valueOf(collection.get(i).getId()), id)){
                collection.remove(i);
                System.out.println("Элемент успешно удален");
                b =0;
            }

    }if (b>collection.size()) {System.out.println("Элемент с таким ID не найден");}
    }
    public static void update(ArrayList<City> collection, int id, City newСity ){
        int b =1;
        for (int i = 0; i < collection.size(); i++){
            b++;
            if (Objects.equals(Integer.valueOf(collection.get(i).getId()), id)){
                collection.set(i, newСity);
                System.out.println("Элемент успешно обновлен");
                b =0;
            }

        }if (b>collection.size()) {System.out.println("Элемент с таким ID не найден");}
    }
    public static void sumOfSeaL(ArrayList<City> collection){
        Double S;
        S =  0.0;
        for (int i = 0; i < collection.size(); i++){
           S = S + collection.get(i).getMetersAboveSeaLevel();
        }
        System.out.println(S);
    }
    public static void averageOfAgg(ArrayList<City> collection){
        Float A;
        A = Float.valueOf(0);
        for (int i = 0; i < collection.size(); i++){
            A = A + collection.get(i).getAgglomeration();
        }
        System.out.println(A/collection.size());
    }
    public static void info(ArrayList<City> collection){
        System.out.println ("коллекция: " + collection.getClass());
        System.out.println("Количество элемeнтов: " + collection.size());
        System.out.println (collection.toString());
    }
public static void save(ArrayList<City> collection) throws IOException {
    Gson gson = new Gson();
    FileOutputStream file=new FileOutputStream("output.json");
    String b = "";
    String c = ""+'\n' ;
if (collection.size()==0){
    file.write(b.getBytes());
    file.close();
}
   else {for (int i=0;i<collection.size()-1; i++){
    String json = gson.toJson(collection.get(i));
    file.write(json.getBytes());
    file.write(c.getBytes());
   }
   String json = gson.toJson(collection.get(collection.size()-1));
   file.write(json.getBytes());

    file.close();
}}
public static void maxCoordinates(ArrayList<City> collection){
        Double C; int j =-1;
        C= -0.1;
    for (int i = 0; i < collection.size(); i++){
      if (Math.sqrt( collection.get(i).getCoordinates().getX()*collection.get(i).getCoordinates().getX()+ collection.get(i).getCoordinates().getY()*collection.get(i).getCoordinates().getY())> C) {
          C=Math.sqrt( collection.get(i).getCoordinates().getX()*collection.get(i).getCoordinates().getX()+ collection.get(i).getCoordinates().getY()*collection.get(i).getCoordinates().getY());
          j=i;
        } }
      System.out.println(collection.get(j));


    }
    public static void script (File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        }










}
