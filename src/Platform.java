import java.awt.*;

public class Platform {
    int x,y,width,height;
    static int dx = 0, dy = 0;
    public Platform(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void update(Player player){
        x -= (player.getDX() - dx);
        y -= (player.getDY() - dy);
    }

    public void paint(Graphics g){
        g.fillRect(x, y, width, height);
    }

    public Rectangle getBounds(){
        return new Rectangle(x,y,width,height);
    }
}
