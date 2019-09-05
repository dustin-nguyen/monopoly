package com.company;

public class House extends Buyable {
    private int buyvalue;
    private int rentvalue=10;
    private int x,y,height,width;

    public House(String name,int buyvalue, int x, int y, int height, int width) {
        super(name,x,y,height,width);
        this.buyvalue=buyvalue;
    }

    public int getBuyValue() {
        return buyvalue;
    }
    public int getRentvalue(){ return rentvalue; }

}
