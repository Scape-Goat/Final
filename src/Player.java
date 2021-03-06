import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    boolean jumping = false;
    boolean onGround = false;
    boolean ableRight = true, ableLeft = true;
    int angle = 0;
    int x, y, width, height, dx = 0, dy = 0;

    public Player(int x, int y, int width, int height){
        this.x = x-width/2 ;
        this.y = y-height/2;
        this.width = width;
        this.height = height;
    }

    public void update(List<Platform> platforms){

        //region Move Left and Right
        for(Platform platform: platforms) {
            if (Game.isLeft() && !Game.isRight()) {
                dx = -10;

            } else if (Game.isRight() && !Game.isLeft()) {
                dx = 10;
            } else {
                if (dx > 0)
                    dx -= 1;
                else if (dx < 0)
                    dx += 1;
            }
        }


        //endregion

        //region Jumping
        if (Game.isJumping() && !jumping) {
            dy = -20;
            jumping = true;        }
        else {
                onGround = false;
            for(Platform platform: platforms) {
                if (getBounds().intersects(platform.getBounds())) {


                    dy = 0;




                    if (y+height-1 > platform.y && y<platform.y) {
                        dy = -1;
                        jumping = false;
                        onGround = true;
                    }
                    else if(y > platform.y){
                        onGround = false;
                        ;

                    }

                    break;

                }
            }
            if(!onGround)
                if(dy<15)
                dy +=1;


        }
        //endregion


    }


    public void attack(int attackType){
        switch(attackType){
            case 0: break;
            case 1: break;
            case 2: break;
        }
    }



    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
    public Rectangle getBounds(int x, int y){
        return new Rectangle(this.x-x,this.y-y,width,height);
    }
    public int getDX() {
        return dx;
    }
    public int getDY() {
        return dy;
    }
    public void paint(Graphics g){
        g.fillOval(x, y, width, height);
    }
}
