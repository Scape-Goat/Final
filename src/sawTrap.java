import java.awt.*;

public class sawTrap {

    int x, y, xCenter, yCenter, speed = 0, orbitWidth = 0, orbitHeight = 0, width = 30, height = 30, angle = 0;

    /****
     *
     * @param x
     * @param y
     */
    public sawTrap(int x, int y){
        xCenter = x;
        yCenter = y;
    }

    /****
     *
     * @param x
     * @param y
     * @param speed
     * @param radius
     */
    public sawTrap(int x, int y, int speed, int radius){
        xCenter = x;
        yCenter = y;
        this.speed = speed;
        orbitWidth = radius;
        orbitHeight = radius;

    }

    /****
     *
     * @param x
     * @param y
     * @param speed
     * @param width
     * @param height
     */
    public sawTrap(int x, int y, int speed, int width, int height){
        xCenter = x;
        yCenter = y;
        this.speed = speed;
        orbitWidth = width;
        orbitHeight = height;
    }

    public void update(Player player){
        xCenter-=player.getDX();
        yCenter-=player.getDY();
        angle +=speed;
        x = (int) (orbitWidth * Math.sin(Math.toRadians( angle)))+xCenter;
        y = (int) (orbitHeight *Math.cos(Math.toRadians( angle)))+yCenter;


    }

    public void paint(Graphics g){
        g.fillOval(x-width/2,y-height/2,width,height);
    }

}
