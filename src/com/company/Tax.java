package com.company;

public class Tax extends Unbuyable {
    private int pay;
    public Tax(String name,int pay,int x, int y, int height, int width){
        super(name,x,y,height,width);
        this.pay=pay;
    }

    @Override
    public void ability(Player player) {player.setMoney(player.getMoney()-pay);
    }

}
