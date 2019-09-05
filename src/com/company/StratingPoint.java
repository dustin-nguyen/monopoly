package com.company;

public class StratingPoint extends Unbuyable {
    public StratingPoint(String name,int x, int y, int height, int width){
        super(name,x,y,height,width);

    }

    @Override
    public void ability(Player player){
        player.setMoney(player.getMoney()+500);
    }
}
