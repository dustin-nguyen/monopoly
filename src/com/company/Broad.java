package com.company;

import net.java.games.input.Component;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.concurrent.ThreadLocalRandom;

public class Broad extends BasicGameState {
    int testX=0;


    public String mouse, player1info, player2info, player1position;
    //////////////////////////////////////////////////////////////////////
    public Image board, background, test,
            player1, player2, player1logo, player2logo,
            rollbutton, endturnbutton, sellbutton, buybutton,
            dice1_1, dice1_2, dice1_3, dice1_4, dice1_5, dice1_6,
            dice2_1, dice2_2, dice2_3, dice2_4, dice2_5, dice2_6;

    public Player Player1 = new Player("player 1");
    public Player Player2 = new Player("player 2");

    private int dice1, dice2;
    CreateLand create_land = new CreateLand();
    private boolean changeplayer = true;///true=plqyer1, flase=player2

    private Shape rectangle;

    private int player1PositionX = 625, player1PositionY = 625,
                  player2PositionX = 625, player2PositionY = 625;

    private int move_between_2lands = 58, move_between_land_to_big_unpayable =71,
                 totalmovement, land_width=58,land_height=84 ;
    //dice pos//////////////////////////////////////////////////////////
    private int dice1_1positionX = 2000,
            dice1_1positionY = 2000,
            dice1_2positionX = 2000,
            dice1_2positionY = 2000,
            dice1_3positionX = 2000,
            dice1_3positionY = 2000,
            dice1_4positionX = 2000,
            dice1_4positionY = 2000,
            dice1_5positionX = 2000,
            dice1_5positionY = 2000,
            dice1_6positionX = 2000,
            dice1_6positionY = 2000;
    private int dice2_1positionX = 2000,
            dice2_1positionY = 2000,
            dice2_2positionX = 2000,
            dice2_2positionY = 2000,
            dice2_3positionX = 2000,
            dice2_3positionY = 2000,
            dice2_4positionX = 2000,
            dice2_4positionY = 2000,
            dice2_5positionX = 2000,
            dice2_5positionY = 2000,
            dice2_6positionX = 2000,
            dice2_6positionY = 2000;

    public Broad(int state) {


    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        dice1_1 = new Image("dice/1.png");
        dice1_2 = new Image("dice/2.png");
        dice1_3 = new Image("dice/3.png");
        dice1_4 = new Image("dice/4.png");
        dice1_5 = new Image("dice/5.png");
        dice1_6 = new Image("dice/6.png");

        dice2_1 = new Image("dice/1.png");
        dice2_2 = new Image("dice/2.png");
        dice2_3 = new Image("dice/3.png");
        dice2_4 = new Image("dice/4.png");
        dice2_5 = new Image("dice/5.png");
        dice2_6 = new Image("dice/6.png");


        //player section/////////////////////////////////////////////
        player1 = new Image("image/player.png");
        player1logo = new Image("image/player.png");
        player2 = new Image("image/bot.png");
        player2logo = new Image("image/bot.png");
        //////////////////////////////////////////////////////////////////
        background = new Image("image/background.png");
        board = new Image("image/monopoly.png");
        //button section/////////////////////////////////////////////////
        rollbutton = new Image("button/roll.png");
        endturnbutton = new Image("button/endturnbutton.png");
        sellbutton = new Image("button/sellbutton.png");
        buybutton = new Image("button/buybutton.png");

        rectangle = new Rectangle(865, 80, 250, 250);
        test= new Image("image/bot.png");
    }


    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw(-84, 0);
        board.draw(0, 0);
        player2.draw(player2PositionX, player2PositionY);
        player1.draw(player1PositionX, player1PositionY);
        test.draw(testX,0);
        drawDicePic();

        rollbutton.draw(940, 550);
        endturnbutton.draw(940, 630);
        buybutton.draw(746, 550);
        sellbutton.draw(1130, 550);
        g.setColor(Color.red);
        g.drawString(mouse, 750, 50);

        //change color to draw/////////////////////////////////////
        g.setColor(Color.white);
        g.fill(rectangle);
        g.setColor(Color.black);
        g.draw(rectangle);
        //add logo and info////////////////////////////////////////
        player1logo.draw(870, 80);
        player2logo.draw(870, 190);
        g.drawString(player1info, 930, 90);
        g.drawString(player2info, 930, 205);
        g.drawString(player1position, 750, 100);

    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {

        Input input = gc.getInput();
        if(input.isKeyPressed(input.KEY_RIGHT)){
            testX++;

        }
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        mouse = "x: " + xpos + " y: " + ypos;
        player1position = "x: " + player1PositionX + "y: " + player1PositionY;
        player1info = "player 1: " + Player1.getMoney() + " $\n";
        player2info = "player 2: " + Player2.getMoney() + " $\n";


        if ((xpos > 940 && xpos < 1065) && (ypos > 7 && ypos < 70)) {    //end turn button position + width (height)
            if (input.isMousePressed(0)) { // 0=left mouse
                if (changeplayer == true)
                    changeplayer = false;       ///true=player1, flase=player2
                else
                    changeplayer = true;
            }

        }

        if ((xpos > 940 && xpos < 1065) && (ypos > 83 && ypos < 144)) {    //roll button position + width (height)
            if (input.isMousePressed(0)) { // 0=left mouse
                dice1 = ThreadLocalRandom.current().nextInt(1, 7);
                dice2 = ThreadLocalRandom.current().nextInt(1, 7);
                totalmovement=dice1+dice2;
                switchcaseDice1and();
                if(changeplayer==true){
                    player1move();
                    player1_pay_tax();
                }
                else {
                    player2move();
                    player2_pay_tax();
                }
            }
        }
        player1_buy_house(xpos,ypos,input);

        if ((xpos > 1130 && xpos < 1255) && (ypos > 83 && ypos < 144)) {    //sell button position + width (height)
            if (input.isMousePressed(0)) { // 0=left mouse
                sbg.enterState(0);
            }
        }
    }
    public void player1_pay_tax(){
        for(int k = 0; k<create_land.horizontal_unbuyable.length; k++){
            int landX=create_land.horizontal_unbuyable[k].getX();
            int landY=create_land.horizontal_unbuyable[k].getY();
            if ((player1PositionX< landX && player1PositionX>(landX-56)) &&(player1PositionY<landY && player1PositionY>(landY-84))){
                create_land.horizontal_unbuyable[k].ability(Player1);
            }
        }
        for (int k = 0; k<create_land.vertical_unbuyable.length; k++){
            int landX=create_land.vertical_unbuyable[k].getX();
            int landY=create_land.vertical_unbuyable[k].getY();
            if ((player1PositionX< landX && player1PositionX>(landX-84)) &&(player1PositionY<landY && player1PositionY>(landY-58))){
                create_land.vertical_unbuyable[k].ability(Player1);
            }
        }
    }
    public void player2_pay_tax(){
        for(int k = 0; k<create_land.horizontal_unbuyable.length; k++){
            int landX=create_land.horizontal_unbuyable[k].getX();
            int landY=create_land.horizontal_unbuyable[k].getY();
            if ((player2PositionX< landX && player2PositionX>(landX-56)) &&(player2PositionY<landY && player2PositionY>(landY-84))){
                create_land.horizontal_unbuyable[k].ability(Player2);
            }
        }
        for (int k = 0; k<create_land.vertical_unbuyable.length; k++){
            int landX=create_land.vertical_unbuyable[k].getX();
            int landY=create_land.vertical_unbuyable[k].getY();
            if ((player2PositionX< landX && player2PositionX>(landX-84)) &&(player2PositionY<landY && player2PositionY>(landY-58))){
                create_land.vertical_unbuyable[k].ability(Player2);
            }
        }
    }
    public void player1_buy_house(int xpos, int ypos, Input input){
        if (changeplayer==true){
            for (int k=0; k<create_land.vertical_house.length;k++){
                int landX=create_land.vertical_house[k].getX();
                int landY=create_land.vertical_house[k].getY();
                if ((player1PositionX< landX && player1PositionX>(landX-84)) &&(player1PositionY<landY && player1PositionY>(landY-58))){
                    if ((xpos > 746 && xpos < 871) && (ypos > 83 && ypos < 144)) {//buy button
                        buy:if (input.isMousePressed(0)) { // 0=left mouse
                          for(int g=0; g<22;g++){
                                if (create_land.vertical_house[k]==Player1.listofhouse[g]){
                                    break buy;
                                }
                            }
                            Player1.buyHouse(create_land.vertical_house[k].getBuyValue(),create_land.vertical_house[k]);

                        }
                    }
                }
            }
            for(int k=0;k<create_land.horizontal_house.length;k++){
                int landX=create_land.horizontal_house[k].getX();
                int landY=create_land.horizontal_house[k].getY();
                if ((player1PositionX< landX && player1PositionX>(landX-56)) &&(player1PositionY<landY && player1PositionY>(landY-84))){
                    if ((xpos > 746 && xpos < 871) && (ypos > 83 && ypos < 144)) {//buy button
                        buy:if (input.isMousePressed(0)) {// 0=left mouse
                            for(int g=0; g<Player1.listofhouse.length;g++){
                                if (create_land.horizontal_house[k]==Player1.listofhouse[g]){
                                    break buy;
                                }
                            }
                            Player1.buyHouse(create_land.horizontal_house[k].getBuyValue(),create_land.horizontal_house[k]);

                        }
                    }
                }
            }
        }
    }
    public void player2move(){
        for (int k = 0; k < totalmovement; k++) {
            outer:
            if (true) {
                if ((player2PositionX > 608 && player2PositionX < 692) && (player2PositionY > 608 && player2PositionY < 692)) {
                    create_land.strating_point.ability(Player2);
                    player2PositionX -= move_between_land_to_big_unpayable;  //Strating Point to Mediteranean
                    break outer;
                }
                if ((player2PositionY > 608 && player2PositionY < 692) && (player2PositionX > 142 && player2PositionX < 608)) {
                    player2PositionX -= move_between_2lands;                //chest1 to Vermon
                    break outer;
                }
                if ((player2PositionX < 142 && player2PositionX > 84) && (player2PositionY > 608 && player2PositionY < 692)) {
                    player2PositionX -= move_between_land_to_big_unpayable; //Connecticut to jail
                    break outer;
                }
                if ((player2PositionX > 0 && player2PositionX < 84) && (player2PositionY > 608 && player2PositionY < 692)) {
                    player2PositionY -= move_between_land_to_big_unpayable; //jail to St.Charles
                    break outer;
                }
                if ((player2PositionX > 0 && player2PositionX < 84) && (player2PositionY > 142 && player2PositionY < 608)){
                    player2PositionY -= move_between_2lands;                 //electric to Tennessee
                    break outer;
                }
                if ((player2PositionX > 0 && player2PositionX < 84) && (player2PositionY < 142 && player2PositionY > 84)){
                    player2PositionY -=  move_between_land_to_big_unpayable;  //Ney York to FreeParking
                    break outer;
                }
                if ((player2PositionX > 0 && player2PositionX < 84) && (player2PositionY > 0 && player2PositionY < 84)){
                    player2PositionX +=  move_between_land_to_big_unpayable;  //FreeParking to  kentucky
                    break outer;
                }
                if ((player2PositionX > 84 && player2PositionX < 550) && (player2PositionY > 0 && player2PositionY < 84)){
                    player2PositionX += move_between_2lands;                 //electric to water
                    break outer;
                }
                if ((player2PositionX > 550 && player2PositionX < 608) && (player2PositionY > 0 && player2PositionY < 84)){
                    player2PositionX += move_between_land_to_big_unpayable;  //marvin to gotojail
                    break outer;
                }
                if ((player2PositionX > 608 && player2PositionX < 692) && (player2PositionY > 0 && player2PositionY < 84)) {
                    player2PositionY += move_between_land_to_big_unpayable;  //gotojail to pacific
                    break outer;
                }
                if ((player2PositionX > 608 && player2PositionX < 692) && (player2PositionY > 84 && player2PositionY < 550)){
                    player2PositionY += move_between_2lands;                 //carolina to luxury
                    break outer;
                }
                if ((player2PositionX > 608 && player2PositionX < 692) && (player2PositionY > 550 && player2PositionY < 608)) {
                    player2PositionY += move_between_land_to_big_unpayable;  //Broadwalk to Strating Point
                    break outer;
                }
            }
        }
    }
    public void player1move(){
        for (int k = 0; k < totalmovement; k++) {
            outer:
            if (true) {
                if ((player1PositionX > 608 && player1PositionX < 692) && (player1PositionY > 608 && player1PositionY < 692)) {
                    create_land.strating_point.ability(Player1);
                    player1PositionX -= move_between_land_to_big_unpayable;  //Strating Point to Mediteranean
                    break outer;
                }
                if ((player1PositionY > 608 && player1PositionY < 692) && (player1PositionX > 142 && player1PositionX < 608)) {
                    player1PositionX -= move_between_2lands;                //chest1 to Vermon
                    break outer;
                }
                if ((player1PositionX < 142 && player1PositionX > 84) && (player1PositionY > 608 && player1PositionY < 692)) {
                    player1PositionX -= move_between_land_to_big_unpayable; //Connecticut to jail
                    break outer;
                }
                if ((player1PositionX > 0 && player1PositionX < 84) && (player1PositionY > 608 && player1PositionY < 692)) {
                    player1PositionY -= move_between_land_to_big_unpayable; //jail to St.Charles
                    break outer;
                }
                if ((player1PositionX > 0 && player1PositionX < 84) && (player1PositionY > 142 && player1PositionY < 608)){
                    player1PositionY -= move_between_2lands;                 //electric to Tennessee
                    break outer;
                }
                if ((player1PositionX > 0 && player1PositionX < 84) && (player1PositionY < 142 && player1PositionY > 84)){
                    player1PositionY  -=  move_between_land_to_big_unpayable;  //Ney York to FreeParking
                    break outer;
                }
                if ((player1PositionX > 0 && player1PositionX < 84) && (player1PositionY > 0 && player1PositionY < 84)){
                    player1PositionX +=  move_between_land_to_big_unpayable;  //FreeParking to  kentucky
                    break outer;
                }
                if ((player1PositionX > 84 && player1PositionX < 550) && (player1PositionY > 0 && player1PositionY < 84)){
                    player1PositionX += move_between_2lands;                 //electric to water
                    break outer;
                }
                if ((player1PositionX > 550 && player1PositionX < 608) && (player1PositionY > 0 && player1PositionY < 84)){
                    player1PositionX += move_between_land_to_big_unpayable;  //marvin to gotojail
                    break outer;
                }
                if ((player1PositionX > 608 && player1PositionX < 692) && (player1PositionY > 0 && player1PositionY < 84)) {
                    player1PositionY += move_between_land_to_big_unpayable;  //gotojail to pacific
                    break outer;
                }
                if ((player1PositionX > 608 && player1PositionX < 692) && (player1PositionY > 84 && player1PositionY < 550)){
                    player1PositionY += move_between_2lands;                 //carolina to luxury
                    break outer;
                }
                if ((player1PositionX > 608 && player1PositionX < 692) && (player1PositionY > 550 && player1PositionY < 608)) {
                    player1PositionY += move_between_land_to_big_unpayable;  //Broadwalk to Strating Point
                    break outer;
                }
            }
        }
    }
    public void switchcaseDice1and() {
        switch (dice1) {
            case 1:
                dice1_1positionX = 900;
                dice1_1positionY = 450;


                dice1_2positionX = 2000;
                dice1_2positionY = 2000;
                dice1_3positionX = 2000;
                dice1_3positionY = 2000;
                dice1_4positionX = 2000;
                dice1_4positionY = 2000;
                dice1_5positionX = 2000;
                dice1_5positionY = 2000;
                dice1_6positionX = 2000;
                dice1_6positionY = 2000;
                break;
            case 2:
                dice1_2positionX = 900;
                dice1_2positionY = 450;

                dice1_1positionX = 2000;
                dice1_1positionY = 2000;
                dice1_3positionX = 2000;
                dice1_3positionY = 2000;
                dice1_4positionX = 2000;
                dice1_4positionY = 2000;
                dice1_5positionX = 2000;
                dice1_5positionY = 2000;
                dice1_6positionX = 2000;
                dice1_6positionY = 2000;
                break;
            case 3:
                dice1_3positionX = 900;
                dice1_3positionY = 450;

                dice1_1positionX = 2000;
                dice1_1positionY = 2000;
                dice1_2positionX = 2000;
                dice1_2positionY = 2000;
                dice1_4positionX = 2000;
                dice1_4positionY = 2000;
                dice1_5positionX = 2000;
                dice1_5positionY = 2000;
                dice1_6positionX = 2000;
                dice1_6positionY = 2000;
                break;
            case 4:
                dice1_4positionX = 900;
                dice1_4positionY = 450;

                dice1_1positionX = 2000;
                dice1_1positionY = 2000;
                dice1_2positionX = 2000;
                dice1_2positionY = 2000;
                dice1_3positionX = 2000;
                dice1_3positionY = 2000;
                dice1_5positionX = 2000;
                dice1_5positionY = 2000;
                dice1_6positionX = 2000;
                dice1_6positionY = 2000;
                break;
            case 5:
                dice1_5positionX = 900;
                dice1_5positionY = 450;

                dice1_1positionX = 2000;
                dice1_1positionY = 2000;
                dice1_2positionX = 2000;
                dice1_2positionY = 2000;
                dice1_3positionX = 2000;
                dice1_3positionY = 2000;
                dice1_4positionX = 2000;
                dice1_4positionY = 2000;
                dice1_6positionX = 2000;
                dice1_6positionY = 2000;
                break;
            case 6:
                dice1_6positionX = 900;
                dice1_6positionY = 450;

                dice1_1positionX = 2000;
                dice1_1positionY = 2000;
                dice1_2positionX = 2000;
                dice1_2positionY = 2000;
                dice1_3positionX = 2000;
                dice1_3positionY = 2000;
                dice1_4positionX = 2000;
                dice1_4positionY = 2000;
                dice1_5positionX = 2000;
                dice1_5positionY = 2000;
                break;
        }

        switch (dice2) {
            case 1:
                dice2_1positionX = 1030;
                dice2_1positionY = 450;


                dice2_2positionX = 2000;
                dice2_2positionY = 2000;
                dice2_3positionX = 2000;
                dice2_3positionY = 2000;
                dice2_4positionX = 2000;
                dice2_4positionY = 2000;
                dice2_5positionX = 2000;
                dice2_5positionY = 2000;
                dice2_6positionX = 2000;
                dice2_6positionY = 2000;
                break;
            case 2:
                dice2_2positionX = 1030;
                dice2_2positionY = 450;

                dice2_1positionX = 2000;
                dice2_1positionY = 2000;
                dice2_3positionX = 2000;
                dice2_3positionY = 2000;
                dice2_4positionX = 2000;
                dice2_4positionY = 2000;
                dice2_5positionX = 2000;
                dice2_5positionY = 2000;
                dice2_6positionX = 2000;
                dice2_6positionY = 2000;
                break;
            case 3:
                dice2_3positionX = 1030;
                dice2_3positionY = 450;

                dice2_1positionX = 2000;
                dice2_1positionY = 2000;
                dice2_2positionX = 2000;
                dice2_2positionY = 2000;
                dice2_4positionX = 2000;
                dice2_4positionY = 2000;
                dice2_5positionX = 2000;
                dice2_5positionY = 2000;
                dice2_6positionX = 2000;
                dice2_6positionY = 2000;
                break;
            case 4:
                dice2_4positionX = 1030;
                dice2_4positionY = 450;

                dice2_1positionX = 2000;
                dice2_1positionY = 2000;
                dice2_2positionX = 2000;
                dice2_2positionY = 2000;
                dice2_3positionX = 2000;
                dice2_3positionY = 2000;
                dice2_5positionX = 2000;
                dice2_5positionY = 2000;
                dice2_6positionX = 2000;
                dice2_6positionY = 2000;
                break;
            case 5:
                dice2_5positionX = 1030;
                dice2_5positionY = 450;

                dice2_1positionX = 2000;
                dice2_1positionY = 2000;
                dice2_2positionX = 2000;
                dice2_2positionY = 2000;
                dice2_3positionX = 2000;
                dice2_3positionY = 2000;
                dice2_4positionX = 2000;
                dice2_4positionY = 2000;
                dice2_6positionX = 2000;
                dice2_6positionY = 2000;
                break;
            case 6:
                dice2_6positionX = 1030;
                dice2_6positionY = 450;

                dice2_1positionX = 2000;
                dice2_1positionY = 2000;
                dice2_2positionX = 2000;
                dice2_2positionY = 2000;
                dice2_3positionX = 2000;
                dice2_3positionY = 2000;
                dice2_4positionX = 2000;
                dice2_4positionY = 2000;
                dice2_5positionX = 2000;
                dice2_5positionY = 2000;
                break;
        }

    }
    public void drawDicePic() {
        dice1_1.draw(dice1_1positionX, dice1_1positionY);
        dice1_2.draw(dice1_2positionX, dice1_2positionY);
        dice1_3.draw(dice1_3positionX, dice1_3positionY);
        dice1_4.draw(dice1_4positionX, dice1_4positionY);
        dice1_5.draw(dice1_5positionX, dice1_5positionY);
        dice1_6.draw(dice1_6positionX, dice1_6positionY);

        dice2_1.draw(dice2_2positionX, dice2_2positionY);
        dice2_2.draw(dice2_2positionX, dice2_2positionY);
        dice2_3.draw(dice2_3positionX, dice2_3positionY);
        dice2_4.draw(dice2_4positionX, dice2_4positionY);
        dice2_5.draw(dice2_5positionX, dice2_5positionY);
        dice2_6.draw(dice2_6positionX, dice2_6positionY);
    }
    public int getID(){
        return 1;
    }

}