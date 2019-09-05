package com.company;
import com.company.Player;

public abstract class  Unbuyable extends Land  {



    public Unbuyable(String name, int x, int y, int height, int width){
        super(name,x,y,height,width);

    }

    public abstract void  ability(Player player);



}
