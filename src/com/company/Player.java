package com.company;



public class Player {
    public House[] listofhouse = new House[22];
    public int numofhouse = 0;
    private int money =0;
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money){
        this.money=money;
    }

    public void buyHouse(int buyvalue, House house) {
        money -= buyvalue;
        listofhouse[numofhouse]=house;
        numofhouse++;
    }

    public void sellHouse(int sellvalue, House house) {
        money+= sellvalue;
        for(int i=0; i<listofhouse.length;i++){
            if(listofhouse[i].getName()==house.getName()){
              listofhouse[i]=listofhouse[i+1];
            }
        }
        numofhouse--;
    }
    @Override
    public String toString() {
        return "name"+ name;
    }
}