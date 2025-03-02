package TankGame02;

public class Tank {
    private int dire = 0;//坦克的朝向
    private int speed = 1;//坦克的移动速度


    private int x;
    private int y;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {y -= getSpeed();}
    public void moveDown() {y += getSpeed();}
    public void moveLeft() {x -= getSpeed();}
    public void moveRight() {x += getSpeed();}

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

    public int getDire() {
        return dire;
    }

    public void setDire(int dire) {
        this.dire = dire;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
