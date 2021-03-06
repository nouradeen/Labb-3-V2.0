// © Copy Right "Nour"
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

public class Ball extends Sprite {
    private final int WIDTH = 800;
    private int xSpeed;
    private int ySpeed;

    
    public Ball(int x, int y, int width, int height, Color color){
        super(x, y, width, height, color);
        //Boll Hastighet
        xSpeed = 4;
        ySpeed = -4;
    }
    @Override
    public void update(Keyboard keyboard) {
        move();
        EdgeChecker();
    
    }

    public void move(){
        setX(getX() + xSpeed);
        setY(getY() + ySpeed);
    }
    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(getColor());
        graphics.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    public void EdgeChecker(){
        /*
        Om x positionen för bollen är lika med eller större än (bredden på fönstret) - (boll bredden) så att bollen inte "åker ut sen förlorar man"
        checken är mellan bollen och väggen till höger. || om x positionen för bollen är lika eller mindre 0 så att bollen inte åker ut när den träffar
        vänster väggen
        */
        if(getX() >= WIDTH - getWidth() || getX() <= 0){
            xSpeed = -xSpeed;
        }
        if(getY() <= 0 || getY() >= 600){
            ySpeed = -ySpeed;
        }
    }

    public boolean BrickCollesion(Bricks brick){
        Rectangle ballRec = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle brickRec = new Rectangle(brick.getX(), brick.getY(), brick.getWidth(), getHeight());
        return ballRec.intersects(brickRec);
    }
    public boolean BatCollision(Bat bat){
        Rectangle ballRec = new Rectangle(getX(), getY(), getWidth(), getHeight());
        Rectangle batRec = new Rectangle(bat.getX(), bat.getY(), bat.getWidth(), bat.getHeight());
        return ballRec.intersects(batRec);
    }


    public int getXSpeed() {
        return this.xSpeed;
    }

    public void setXSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public int getYSpeed() {
        return this.ySpeed;
    }

    public void setYSpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    
}