package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


public class game extends StateBasedGame {

   public static final String gamename="Monopoly";
   public static final int menu=0;
   public static final int broad=1;

   public game( String  gamename){
       super(gamename);
       this.addState(new Menu(menu));
       this.addState(new Broad(broad));
   }


    @Override
    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(menu) .init(gc, this);
        this.getState(broad).init(gc, this);
        this.enterState(menu);
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new game(gamename));
        app.setDisplayMode(1280, 696, false);
        app.setTargetFrameRate(160);
        app.start();
    }
}
