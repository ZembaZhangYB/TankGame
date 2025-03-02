package TankGame03;

public class Player extends Tank {
    //定义一个子弹对象
    private Shot shot = null;

    public Shot getShot() {
        return shot;
    }

    public Player(int x, int y) {
        super(x, y);
    }

    public void shotEnemy (){
        //创建一个shot对象
        switch(getDire()){//得到坦克的方向,0123上右下左
            case 0:
                shot = new Shot(getX() + 20, getY(), 0);
                break;
            case 1:
                shot = new Shot(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                shot = new Shot(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                shot = new Shot(getX(), getY() + 20, 3);
                break;
        }

        new Thread(shot).start();
    }
}
