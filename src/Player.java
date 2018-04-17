import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Player {
    boolean jumping = false;
    int x, y, width, height, dx = 0, dy = 0;
    public Player(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(List<Platform> platforms){

        //region Move Left and Right
        if(Game.isLeft() && !Game.isRight()){
            dx = -5;

        }
        else if(Game.isRight() && !Game.isLeft()){
            dx = 5;
        }
        else{
            dx = 0;
        }

        //endregion

        //region Jumping
        if (Game.isJumping() && !jumping) {
            dy = -30;
            jumping = true;
        }
        else {
            for(Platform platform: platforms) {
                if (getBounds().intersects(platform.getBounds())) {
                    dy = 0;
                    jumping = false;

                    if (y+height-1 > platform.y) {
                        dy -= 1;
                    }
                    break;
                }else {
                    dy += 1;
                }
            }
        }
        //endregion

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
