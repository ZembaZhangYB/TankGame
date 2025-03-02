package TankGame06;

public class Tank {
    private int x;
    private int y;
    private int direct;
    private int speed;
    boolean isLive=true;
    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp(){
        direct=0;
        this.y=this.y-speed;
    }
    public void moveDown(){
        direct=2;
        y=y+speed;
    }
    public void moveLeft(){
        direct=3;
        x=x-speed;
    }
    public void moveRight(){
        direct=1;
        x=x+speed;
    }
    public Tank(int x, int y,int direct,int speed) {
        this.x = x;
        this.y = y;
        this.direct=direct;
        this.speed=speed;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
