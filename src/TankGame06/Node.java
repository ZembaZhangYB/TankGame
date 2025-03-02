package TankGame06;

public class Node {
    private int x;
    private int y;
    private int direct;
    private int button=0;
    public Node(int x,int y,int direct){
        this.x=x;
        this.y=y;
        this.direct=direct;
    }
    public Node(int button){
        this.button=button;
    }

    public int getButton() {
        return button;
    }

    public void setButton(int button) {
        this.button = button;
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

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }
}
