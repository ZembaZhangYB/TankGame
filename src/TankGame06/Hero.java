package TankGame06;

import java.util.Vector;

public class Hero extends Tank {
    boolean islive=true;
    Shot shot=null;
    Vector<Shot> shots=new Vector<>();


    public Hero(int x, int y,int direct,int speed ) {
        super(x, y,direct,speed);
    }
    public void shotEnemyTank(){
        switch (getDirect()){
            case 0:
                if(shots.size()<5){
                    shot=new Shot(getX()+20,getY(),0);
                    new Thread(shot).start();
                    shots.add(shot);
                }
                break;
            case 1:
                if(shots.size()<5) {
                    shot = new Shot(getX() + 60, getY() + 20, 1);
                    new Thread(shot).start();
                    shots.add(shot);
                }
                break;
            case 2:
                if(shots.size()<5) {
                    shot = new Shot(getX() + 20, getY() + 60, 2);
                    new Thread(shot).start();
                    shots.add(shot);
                }break;
            case 3:
                if(shots.size()<5){
                    shot=new Shot(getX(),getY()+20,3);
                    new Thread(shot).start();
                    shots.add(shot);
                }
                break;
        }
    }
}
