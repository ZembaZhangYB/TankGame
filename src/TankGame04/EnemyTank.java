package TankGame04;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{//敌人的坦克
    Vector<Shot> shots = new Vector<>();

    boolean isLive = true;

    public EnemyTank(int x, int y) {
        super(x, y);
    }

    @Override
    public void run(){
        while(true){
            //根据坦克方向来继续移动，然后随机改变坦克方向
            switch(getDire()){
                case 0:
                    for(int i = 0; i < 30; i ++){
                        if (getY() > 0) {
                        moveUp();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }}
                    break;
                case 1:
                    for(int i = 0; i < 30; i ++){
                        if(getX() > 1000){
                        moveRight();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }}}
                    break;
                case 2:
                    for(int i = 0; i < 30; i ++){
                        if(getY() + 60 < 750){
                        moveDown();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        }
                    }
                    break;
                case 3:
                    for(int i = 0; i < 30; i ++){
                        if(getX() > 0){
                        moveLeft();
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }}}
                    break;
            }

            setDire((int)Math.random() * 4);
            if(isLive) break;
        }
    }
}
