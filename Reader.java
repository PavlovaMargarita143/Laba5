package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Reader{


    //public Reader(){}
    public Command ReadCommand(){
        Command command=null;
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
           ArrayList In = new ArrayList();
            if ((input.compareTo("Script")==0)|| (input.compareTo("script")==0)){
                System.out.println("Выполняем команду " + input);
               System.out.println("Введите название файла");
               String  file = scanner.next();
               command = new Command_Script(new File(file));
               FileReader fr = null;
               try {
                   fr = new FileReader(file);
               } catch (FileNotFoundException e) {
                   e.printStackTrace();
                   System.out.println("Такого файла не существует!!!");
               }
               BufferedReader reader = new BufferedReader(fr);
               // считаем сначала первую строку
               String line = null;
               try {
                   line = reader.readLine();
               } catch (IOException e) {
                   e.printStackTrace();
               }
               while (line != null) {
                   String a = line;

                   try {
                       line = reader.readLine();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                  String[] w = a.split(" ");

                    if (w[0].compareTo("RemoveAt")==0) {
                      if (A_Command.getSet().size()== 0){
                          System.out.println("Коллекция пуста, вы не можетe удалить элементы");
                          continue;

                      }
                        if (w.length<2){
                            System.out.println("Не хватает данных для выполнения команды RemoveAt, пожалуйста, исправьте данные файла");
                            continue;
                        }
                      while (true){

                        boolean result = w[1].matches("\\d+");
                        if (result == false) {
                            System.out.println("ОШИБКА!! Введите положительное целое число!");
                            w[1]=scanner.next();

                        } else if ((result == true) && (Integer.parseInt(w[0]) >= A_Command.getSet().size())) {
                            System.out.println("ОШИБКА!! Элемента с таким индексом не существует, введите число МЕНЬШЕ чем " + A_Command.getSet().size());
                            w[1]=scanner.next();
                        }
                      else break;}

                      int ind = Integer.parseInt(w[1]);
                      command= new Command_RemoveAt(ind);
                      command.execute();
                      System.out.println(w[1]+" Элемент успешно удален");

                   } else if (w[0].compareTo("RemoveById")==0) {
                        if (w.length<2){
                            System.out.println("Не хватает данных для выполнения команды RemoveById, пожалуйста, исправьте данные файла");
                            continue;
                        }
                        while (true){
                            boolean result = w[1].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число!");
                                w[1]=scanner.next();

                            }else break;}
                            int ind = Integer.parseInt(w[1]);
                      command= new Command_RemoveById(ind);
                      command.execute();
                  } else if (w[0].compareTo("Add")==0){
                        if (w.length<11){
                            System.out.println("Не хватает данных для выполнения команды Add, пожалуйста, исправьте данные файла, строка должна содержать минимум 7 значений после названия команды");
                            continue;
                        }
                        while (true){
                            boolean result = w[2].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для х!");
                                w[2]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[3].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для у!");
                                w[3]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[4].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для площади!");
                                w[4]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[5].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для количества населения!");
                                w[5]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[6].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число высоты над уровнем моря !");
                                w[6]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[7].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для аггломерации!");
                                w[7]=scanner.next();

                            }else break;}
                        while (true) {

                            if (w[10].compareTo("-")==0){
                                break;
                            }
                            boolean result = w[10].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число!");
                                w[10]=scanner.next();
                            }
                            else if ((result==true)&&((Integer.parseInt(w[10])>80)||(Integer.parseInt(w[10])<25))){
                                System.out.println("ОШИБКА!! Возраст губернатора не может быть больше 80 или меньше 25, введите другое число");
                                w[10]=scanner.next();
                            }
                            else break;
                        }

                        while (true) {

                            if ((w[8].contains("THALASSOCRARY") || w[8].contains("JUNTA") || w[8].contains("ETNOCRACY") || w[8].contains("OLIGARCHY")) == true) {
                                break;
                            } else {
                                System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                                 w[8]=scanner.next();}
                        }


                        while (true) {

                            if (w[9].compareTo("-")==0){
                                break;
                            }
                            if ((w[9].contains("ULTRA_HIGH") || w[9].contains("HIGH") || w[9].contains("LOW") || w[9].contains("ULTRA_LOW")||w[9].contains("NIGHTMARE")) == true) {
                                break;
                            } else{
                                System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                                   w[9]= scanner.next();}}


                       if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")==0)){
                       command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                               Float.parseFloat(w[7]),Government.valueOf(w[8].trim())));}
                      else   if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")!=0)){
                            command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                    Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim())));}
                      else if ((w[9].compareTo("-")!=0)&&(w[10].compareTo("-")==0)){
                            command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                    Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),new Human(Integer.parseInt(w[10]))));}
                        else  command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                   Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim()),new Human(Integer.parseInt(w[10]))));

                      command.execute();
                       System.out.println("элемент успешно добавлен");
                  }
                   else if (w[0].compareTo("UpdateId")==0){
                        if (w.length<12){
                            System.out.println("Не хватает данных для выполнения команды UpdateId, пожалуйста, исправьте данные файла, строка должна содержать минимум 8 значений после названия команды, последнее число является ID обновляемого элемента");
                            continue;
                        }
                        while (true){
                            boolean result = w[2].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для х!");
                                w[2]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[3].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для у!");
                                w[3]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[4].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для площади!");
                                w[4]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[5].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для количества населения!");
                                w[5]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[6].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число высоты над уровнем моря !");
                                w[6]=scanner.next();

                            }else break;}
                        while (true){
                            boolean result = w[7].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для аггломерации!");
                                w[7]=scanner.next();

                            }else break;}
                        while (true) {

                            if (w[10].compareTo("-")==0){
                                break;
                            }
                            boolean result = w[10].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число!");
                                w[10]=scanner.next();
                            }
                            else if ((result==true)&&((Integer.parseInt(w[10])>80)||(Integer.parseInt(w[10])<25))){
                                System.out.println("ОШИБКА!! Возраст губернатора не может быть больше 80 или меньше 25, введите другое число");
                                w[10]=scanner.next();
                            }
                            else break;
                        }

                        while (true) {

                            if ((w[8].contains("THALASSOCRARY") || w[8].contains("JUNTA") || w[8].contains("ETNOCRACY") || w[8].contains("OLIGARCHY")) == true) {
                                break;
                            } else {
                                System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                                w[8]=scanner.next();}
                        }


                        while (true) {

                            if (w[9].compareTo("-")==0){
                                break;
                            }
                            if ((w[9].contains("ULTRA_HIGH") || w[9].contains("HIGH") || w[9].contains("LOW") || w[9].contains("ULTRA_LOW")||w[9].contains("NIGHTMARE")) == true) {
                                break;
                            } else{
                                System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                                w[9]= scanner.next();}}
                        while (true){
                            boolean result = w[11].matches("\\d+");
                            if (result == false) {
                                System.out.println("ОШИБКА!! Введите положительное целое число для ID!");
                                w[11]=scanner.next();

                            }else break;}


                        if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")==0)){
                            command= new Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                    Float.parseFloat(w[7]),Government.valueOf(w[8].trim())));}
                        else   if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")!=0)){
                            command= new  Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                    Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim())));}
                        else if ((w[9].compareTo("-")!=0)&&(w[10].compareTo("-")==0)){
                            command= new  Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                    Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),new Human(Integer.parseInt(w[10]))));}
                        else  command= new  Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                    Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim()),new Human(Integer.parseInt(w[10]))));

                        command.execute();

                  }




                   else In.add(w[0]);


               }}
            else In.add(input);
           for (int i = 0; i< In.size(); i++) {
               input = (String) In.get(i);
               System.out.println("Выполняем команду "+ input);
               if ((input.compareTo("Script")==0)|| (input.compareTo("script")==0)){

                   command = new Command_Script(new File("Script.txt"));
                   FileReader fr = null;
                   try {
                       fr = new FileReader("Script.txt");
                   } catch (FileNotFoundException e) {
                       e.printStackTrace();
                       System.out.println("Такого файла не существует!!!");
                   }
                   BufferedReader reader = new BufferedReader(fr);
                   // считаем сначала первую строку
                   String line = null;
                   try {
                       line = reader.readLine();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                   while (line != null) {
                       String a;
                       a = line;
                       try {
                           line = reader.readLine();
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                       String[] w = a.split(" ");

                       if (w[0].compareTo("RemoveAt")==0) {

                           if (A_Command.getSet().size()== 0){
                               System.out.println("Коллекция пуста, вы не можетe удалить элементы");
                               continue;
                           } if (w.length<2){
                               System.out.println("Не хватает данных для выполнения команды RemoveAt, пожалуйста, исправьте данные файла");
                               continue;
                           }
                           while (true){
                               boolean result = w[1].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число!");
                                   w[1]=scanner.next();

                               } else if ((result == true) && (Integer.parseInt(w[0]) >= A_Command.getSet().size())) {
                                   System.out.println("ОШИБКА!! Элемента с таким индексом не существует, введите число МЕНЬШЕ чем " + A_Command.getSet().size());
                                   w[1]=scanner.next();
                               }
                               else break;}

                           int ind = Integer.parseInt(w[1]);
                           command= new Command_RemoveAt(ind);
                           command.execute();
                           System.out.println(w[1]+" Элемент успешно удален");

                       } else if (w[0].compareTo("RemoveById")==0) {
                           if (w.length<2){
                               System.out.println("Не хватает данных для выполнения команды RemoveById, пожалуйста, исправьте данные файла");
                               continue;
                           }
                           while (true){
                               boolean result = w[1].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число!");
                                   w[1]=scanner.next();

                               }else break;}
                           int ind = Integer.parseInt(w[1]);
                           command= new Command_RemoveById(ind);
                           command.execute();
                       } else if (w[0].compareTo("Add")==0){
                           if (w.length<11){
                               System.out.println("Не хватает данных для выполнения команды Add, пожалуйста, исправьте данные файла, строка должна содержать минимум 7 значений после названия команды");
                               continue;
                           }
                           while (true){
                               boolean result = w[2].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для х!");
                                   w[2]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[3].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для у!");
                                   w[3]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[4].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для площади!");
                                   w[4]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[5].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для количества населения!");
                                   w[5]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[6].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число высоты над уровнем моря !");
                                   w[6]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[7].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для аггломерации!");
                                   w[7]=scanner.next();

                               }else break;}
                           while (true) {

                               if (w[10].compareTo("-")==0){
                                   break;
                               }
                               boolean result = w[10].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число!");
                                   w[10]=scanner.next();
                               }
                               else if ((result==true)&&((Integer.parseInt(w[10])>80)||(Integer.parseInt(w[10])<25))){
                                   System.out.println("ОШИБКА!! Возраст губернатора не может быть больше 80 или меньше 25, введите другое число");
                                   w[10]=scanner.next();
                               }
                               else break;
                           }

                           while (true) {

                               if ((w[8].contains("THALASSOCRARY") || w[8].contains("JUNTA") || w[8].contains("ETNOCRACY") || w[8].contains("OLIGARCHY")) == true) {
                                   break;
                               } else {
                                   System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                                   w[8]=scanner.next();}
                           }


                           while (true) {

                               if (w[9].compareTo("-")==0){
                                   break;
                               }
                               if ((w[9].contains("ULTRA_HIGH") || w[9].contains("HIGH") || w[9].contains("LOW") || w[9].contains("ULTRA_LOW")||w[9].contains("NIGHTMARE")) == true) {
                                   break;
                               } else{
                                   System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                                   w[9]= scanner.next();}}


                           if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")==0)){
                               command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim())));}
                           else   if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")!=0)){
                               command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim())));}
                           else if ((w[9].compareTo("-")!=0)&&(w[10].compareTo("-")==0)){
                               command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),new Human(Integer.parseInt(w[10]))));}
                           else  command= new  Command_Add(new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim()),new Human(Integer.parseInt(w[10]))));

                           command.execute();
                           System.out.println("элемент успешно добавлен");
                       }
                       else if (w[0].compareTo("UpdateId")==0){
                           if (w.length<12){
                               System.out.println("Не хватает данных для выполнения команды UpdateId, пожалуйста, исправьте данные файла, строка должна содержать минимум 8 значений после названия команды, последнее число является ID обновляемого элемента");
                               continue;
                           }
                           while (true){
                               boolean result = w[2].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для х!");
                                   w[2]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[3].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для у!");
                                   w[3]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[4].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для площади!");
                                   w[4]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[5].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для количества населения!");
                                   w[5]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[6].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число высоты над уровнем моря !");
                                   w[6]=scanner.next();

                               }else break;}
                           while (true){
                               boolean result = w[7].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для аггломерации!");
                                   w[7]=scanner.next();

                               }else break;}
                           while (true) {

                               if (w[10].compareTo("-")==0){
                                   break;
                               }
                               boolean result = w[10].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число!");
                                   w[10]=scanner.next();
                               }
                               else if ((result==true)&&((Integer.parseInt(w[10])>80)||(Integer.parseInt(w[10])<25))){
                                   System.out.println("ОШИБКА!! Возраст губернатора не может быть больше 80 или меньше 25, введите другое число");
                                   w[10]=scanner.next();
                               }
                               else break;
                           }

                           while (true) {

                               if ((w[8].contains("THALASSOCRARY") || w[8].contains("JUNTA") || w[8].contains("ETNOCRACY") || w[8].contains("OLIGARCHY")) == true) {
                                   break;
                               } else {
                                   System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                                   w[8]=scanner.next();}
                           }


                           while (true) {

                               if (w[9].compareTo("-")==0){
                                   break;
                               }
                               if ((w[9].contains("ULTRA_HIGH") || w[9].contains("HIGH") || w[9].contains("LOW") || w[9].contains("ULTRA_LOW")||w[9].contains("NIGHTMARE")) == true) {
                                   break;
                               } else{
                                   System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                                   w[9]= scanner.next();}}
                           while (true){
                               boolean result = w[11].matches("\\d+");
                               if (result == false) {
                                   System.out.println("ОШИБКА!! Введите положительное целое число для ID!");
                                   w[11]=scanner.next();

                               }else break;}


                           if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")==0)){
                               command= new Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim())));}
                           else   if ((w[9].compareTo("-")==0)&&(w[10].compareTo("-")!=0)){
                               command= new  Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim())));}
                           else if ((w[9].compareTo("-")!=0)&&(w[10].compareTo("-")==0)){
                               command= new  Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),new Human(Integer.parseInt(w[10]))));}
                           else  command= new  Command_UpdateId(Integer.parseInt(w[11]),new City(w[1],new Coordinates(Long.parseLong(w[2]),Integer.parseInt(w[3])),Double.parseDouble(w[4]),Integer.parseInt(w[5]),Double.parseDouble(w[6]),
                                       Float.parseFloat(w[7]),Government.valueOf(w[8].trim()),StandardOfLiving.valueOf(w[9].trim()),new Human(Integer.parseInt(w[10]))));

                           command.execute();


                       }





                       else In.add(w[0]);


                   } continue;
               }
               if ((input.compareTo("Help") == 0)|| (input.compareTo("help")==0)) {
                   command = new Command_Help();
               } else if ((input.compareTo("Exit") == 0)|| (input.compareTo("exit")==0)) {
                   command = new Command_Exit();
               } else if ((input.compareTo("Show") == 0)||(input.compareTo("show") == 0)) {
                   command = new Command_Show();
               } else if ((input.compareTo("Sort") == 0)||(input.compareTo("sort") == 0)) {
                   command = new Command_Sort();
               } else if ((input.compareTo("Clear") == 0)||(input.compareTo("clear") == 0)) {
                   command = new Command_Clear();
               } else if ((input.compareTo("Shuffle") == 0)||(input.compareTo("shuffle") == 0)) {
                   command = new Command_Shuffle();
               } else if ((input.compareTo("RemoveAt") == 0)||(input.compareTo("removeat") == 0)||(input.compareTo("removeAt") == 0)) {
                   if (A_Command.getSet().size()== 0){
                       System.out.println("Коллекция пуста, вы не можетe удалить элементы");
                       continue;
                   }
                   System.out.println("Введите индекс элемента, который хотите удалить");
                   String ind = null;
                   while (true) {
                       ind = scanner.next();
                       boolean result = ind.matches("\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное целое число!");
                       } else if ((result == true) && (Integer.parseInt(ind) >= A_Command.getSet().size())) {
                           System.out.println("ОШИБКА!! Элемента с таким индексом не существует, введите число МЕНЬШЕ чем " + A_Command.getSet().size());
                       } else break;
                   }
                   Integer index = Integer.parseInt(ind);
                   command = new Command_RemoveAt(index);
               } else if ((input.compareTo("Add") == 0)||(input.compareTo("add") == 0)) {
                   System.out.println("Введите название города ");
                   String name = scanner.nextLine();
                   System.out.println("Введите координаты x затем y");
                   String x1 = null;
                   System.out.println("Введите x");
                   while (true) {
                       x1 = scanner.nextLine();
                       boolean result = x1.matches("-?\\d+?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите целое число!");
                       } else break;
                   }
                   long x = Long.parseLong(x1);
                   System.out.println("Введите y");
                   String y1 = null;
                   while (true) {
                       y1 = scanner.nextLine();
                       boolean result = y1.matches("-?\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!!Введите целое число!");
                       } else break;
                   }
                   int y = Integer.parseInt(y1);

                   System.out.println("Введите площадь");
                   String y2 = null;
                   while (true) {
                       y2 = scanner.nextLine();
                       boolean result = y2.matches("\\d+(\\.\\d+)?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное число формата 12.12!");
                       } else break;
                   }
                   Double area = Double.parseDouble(y2);
                   System.out.println("Введите количество населения");
                   String y3 = null;
                   while (true) {
                       y3 = scanner.nextLine();
                       boolean result = y3.matches("\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное целое число!");
                       } else break;
                   }
                   int pop = Integer.parseInt(y3);

                   System.out.println("Введите высоту над уровнем моря, в метрах");
                   String y4 = null;
                   while (true) {
                       y4 = scanner.nextLine();
                       boolean result = y4.matches("-?\\d+(\\.\\d+)?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите число формата 12.12!");
                       } else break;
                   }
                   Double SL = Double.parseDouble(y4);
                   System.out.println("Введите аггломирацию");
                   String y5 = null;
                   while (true) {
                       y5 = scanner.nextLine();
                       boolean result = y5.matches("\\d+(\\.\\d+)?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное число в формате 12.12!");
                       } else break;
                   }
                   System.out.println("Введите возраст губернатора");
                   String y9 = null;
                   while (true) {
                       y9 = scanner.nextLine();
                       if (y9.compareTo("")==0){
                           break;
                       }
                       boolean result = y9.matches("\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное целое число!");}
                       else if ((result==true)&&((Integer.parseInt(y9)>80)||(Integer.parseInt(y9)<25))){
                           System.out.println("ОШИБКА!! Возраст губернатора не может быть больше 80 или меньше 25, введите другое число");
                       }
                       else break;
                   }

                   Float agg = Float.parseFloat(y5);
                   System.out.println("Введите систему правления из предложенных :THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                   String g1 = null;
                   while (true) {
                       g1 = scanner.nextLine();
                       if ((g1.contains("THALASSOCRARY") || g1.contains("JUNTA") || g1.contains("ETNOCRACY") || g1.contains("OLIGARCHY")) == true) {
                           break;
                       } else
                           System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                   }
                   String g = g1;
                   System.out.println("Введите уровень жизни из предложенных  :ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                   String s1 = null;
                   while (true) {
                       s1 = scanner.nextLine();
                       if (s1.compareTo("")==0){
                           break;
                       }
                       if ((s1.contains("ULTRA_HIGH") || s1.contains("HIGH") || s1.contains("LOW") || s1.contains("ULTRA_LOW")||s1.contains("NIGHTMARE")) == true) {
                           break;
                       } else
                           System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                   }
                   String s = s1;
                   if ((y9.compareTo("")==0)&&(s.compareTo("")==0)){
                       command = new Command_Add(new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim())));
                   }
                   else if ((y9.compareTo("")==0)&&(s.compareTo("")!=0)) {
                       command = new Command_Add(new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim()),StandardOfLiving.valueOf(s.trim())));}

                   else if ((s.compareTo("")==0)&&(y9.compareTo("")!=0)){
                        int age = Integer.parseInt(y9);
                        command = new Command_Add(new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim()),new Human(age)));}

                   else { int age = Integer.parseInt(y9);
                       command = new Command_Add(new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim()),StandardOfLiving.valueOf(s.trim()),new Human(age)));}
                   }


                else if ((input.compareTo("RemoveById") == 0)||(input.compareTo("removebyid") == 0)||(input.compareTo("removeById") == 0)) {
                   System.out.println("Введите ID элемента, который хотите удалить");
                   String id1 = null;
                   while (true) {
                       id1 = scanner.next();
                       boolean result = id1.matches("\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное целое число!");
                       } else break;
                   }
                   int id = Integer.parseInt(id1);

                   command = new Command_RemoveById(id);

               } else if ((input.compareTo("UpdateId") == 0)||(input.compareTo("updateid") == 0)||(input.compareTo("updateId") == 0)) {
                   System.out.println("Введите id элемента который хотите обновить");
                   String id1 = null;
                   while (true) {
                       id1 = scanner.next();
                       boolean result = id1.matches("\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите число!");
                       } else break;
                   }
                   int id = Integer.parseInt(id1);

                   System.out.println("Введите новый объект коллекции");
                   System.out.println("Введите название города ");
                   String name = scanner.nextLine();
                   System.out.println("Введите координаты x затем y");
                   String x1 = null;
                   System.out.println("Введите x");
                   while (true) {
                       x1 = scanner.nextLine();
                       boolean result = x1.matches("-?\\d+?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите целое число!");
                       } else break;
                   }
                   long x = Long.parseLong(x1);
                   System.out.println("Введите y");
                   String y1 = null;
                   while (true) {
                       y1 = scanner.nextLine();
                       boolean result = y1.matches("-?\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!!Введите целое число!");
                       } else break;
                   }
                   int y = Integer.parseInt(y1);

                   System.out.println("Введите площадь");
                   String y2 = null;
                   while (true) {
                       y2 = scanner.nextLine();
                       boolean result = y2.matches("\\d+(\\.\\d+)?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное число формата 12.12!");
                       } else break;
                   }
                   Double area = Double.parseDouble(y2);
                   System.out.println("Введите количество населения");
                   String y3 = null;
                   while (true) {
                       y3 = scanner.nextLine();
                       boolean result = y3.matches("\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное целое число!");
                       } else break;
                   }
                   int pop = Integer.parseInt(y3);

                   System.out.println("Введите высоту над уровнем моря, в метрах");
                   String y4 = null;
                   while (true) {
                       y4 = scanner.nextLine();
                       boolean result = y4.matches("-?\\d+(\\.\\d+)?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите число формата 12.12!");
                       } else break;
                   }
                   Double SL = Double.parseDouble(y4);
                   System.out.println("Введите аггломирацию");
                   String y5 = null;
                   while (true) {
                       y5 = scanner.nextLine();
                       boolean result = y5.matches("\\d+(\\.\\d+)?");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное число в формате 12.12!");
                       } else break;
                   }
                   System.out.println("Введите возраст губернатора");
                   String y9 = null;
                   while (true) {
                       y9 = scanner.nextLine();
                       if (y9.compareTo("")==0){
                           break;
                       }
                       boolean result = y9.matches("\\d+");
                       if (result == false) {
                           System.out.println("ОШИБКА!! Введите положительное целое число!");}
                       else if ((result==true)&&((Integer.parseInt(y9)>80)||(Integer.parseInt(y9)<25))){
                           System.out.println("ОШИБКА!! Возраст губернатора не может быть больше 80 или меньше 25, введите другое число");
                       }
                       else break;
                   }

                   Float agg = Float.parseFloat(y5);
                   System.out.println("Введите систему правления из предложенных :THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                   String g1 = null;
                   while (true) {
                       g1 = scanner.nextLine();
                       if ((g1.contains("THALASSOCRARY") || g1.contains("JUNTA") || g1.contains("ETNOCRACY") || g1.contains("OLIGARCHY")) == true) {
                           break;
                       } else
                           System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: THALASSOCRARY, JUNTA, ETNOCRACY, OLIGARCHY");
                   }
                   String g = g1;
                   System.out.println("Введите уровень жизни из предложенных  :ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                   String s1 = null;
                   while (true) {
                       s1 = scanner.nextLine();
                       if (s1.compareTo("")==0){
                           break;
                       }
                       if ((s1.contains("ULTRA_HIGH") || s1.contains("HIGH") || s1.contains("LOW") || s1.contains("ULTRA_LOW")||s1.contains("NIGHTMARE")) == true) {
                           break;
                       } else
                           System.out.println("ОШИБКА!! Выберете слово из предложенных и введите его: ULTRA_HIGH, HIGH, LOW, ULTRA_LOW,NIGHTMARE");
                   }
                   String s = s1;
                   if ((y9.compareTo("")==0)&&(s.compareTo("")==0)){
                       command = new Command_UpdateId(id,new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim())));
                   }
                   else if ((y9.compareTo("")==0)&&(s.compareTo("")!=0)) {
                       command = new Command_UpdateId(id,new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim()),StandardOfLiving.valueOf(s.trim())));}

                   else if ((s.compareTo("")==0)&&(y9.compareTo("")!=0)){
                       int age = Integer.parseInt(y9);
                       command = new Command_UpdateId(id,new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim()),new Human(age)));}

                   else { int age = Integer.parseInt(y9);
                       command = new Command_UpdateId(id,new City(name, new Coordinates(x, y), (Double) area, pop, SL, agg,Government.valueOf(g.trim()),StandardOfLiving.valueOf(s.trim()),new Human(age)));}
               }


           else if ((input.compareTo("SumOfSeaLevel") == 0)||(input.compareTo("sumofsealevel") == 0)||(input.compareTo("sumOfSeaLevel") == 0)) {
                   command = new Command_SumOfSeaLevel();
               } else if ((input.compareTo("AverageOfAgg") == 0)||(input.compareTo("averageofagg") == 0)||(input.compareTo("averageOfAgg") == 0)) {
                   if (A_Command.getSet().size()==0){
                       System.out.println(0);
                       continue;
                   }
                   command = new Command_AverageOfAgglomeration();
               } else if ((input.compareTo("Info") == 0)||(input.compareTo("info") == 0)) {
                   command = new Command_Info();
               } else if ((input.compareTo("Save") == 0)||(input.compareTo("save") == 0)) {
                   command = new Command_Save();
               } else if ((input.compareTo("MaxCoordinates") == 0)||(input.compareTo("maxcoordinates") == 0)||(input.compareTo("maxCoordinates") == 0)) {
                   if (A_Command.getSet().size()==0){
                       System.out.println("коллекция пуста, элемент с максимальным значением поля координаты не может быть найден");
                       continue;
                   }
                   command = new Command_MaxCoordinates();
               } else {
                   command = new Command_Error();
               }

    command.execute();
    }
           return command;}
}
