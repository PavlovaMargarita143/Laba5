package com.company;

public class Human {
    private int age; //Значение поля должно быть больше 0
    Human(int age){
        if (!(age < 0)) this.age= age;
        else throw new IllegalArgumentException("Значение age должно быть >0");
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "{" + '\n'+
                "<age>:" + age + '\n'+
                "}";
    }

}
