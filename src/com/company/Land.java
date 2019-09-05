package com.company;

public abstract class Land {
    private String name;
    private int x,y,height,width;

    public Land(String name, int x, int y, int height, int width){
        this.name=name;
        this.x=x;
        this.y=y;
        this.height=height;
        this.width=width;
    }

    public String getName(){
        return name;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getHeight() { return height; }

    public int getWidth() {
        return width;
    }
}
