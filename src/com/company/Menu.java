package com.company;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.lwjgl.input.Mouse;

public class Menu extends BasicGameState {

    Image menucover,man,playbutton;
    Music openning;
    public Menu(int state) {

    }

    @Override
    public void init(GameContainer gc,StateBasedGame sbg) throws SlickException{
        menucover= new Image("image/menu.png");
        man = new Image("image/b_man.png");
        playbutton= new Image("button/playbutton.png");
        openning= new Music("audio/Title_Theme.ogg");
    }

    @Override
    public void render(GameContainer gc,StateBasedGame sbg, Graphics g) throws SlickException {
        openning.loop();
        menucover.draw(0,0);
        man.draw(945,260);
        playbutton.draw(525,600);

    }

    @Override
    public void update(GameContainer gc,StateBasedGame sbg, int i) throws SlickException {
        int xpos= Mouse.getX();
        int ypos= Mouse.getY();
        Input input = gc.getInput();

        if ((xpos>525 && xpos<705) && (ypos>22 && ypos<92)) {    //play button position + width (height)
            if(input.isMousePressed(0)) { // 0=left mouse
               sbg.enterState(1);   // change to broad, broad=1
            }
        }
    }

    public int getID(){
        return 0;
    }


}
