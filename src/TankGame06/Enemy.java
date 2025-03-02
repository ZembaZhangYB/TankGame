package TankGame06;

import java.util.Vector;

public class Enemy extends Tank implements Runnable{
    Vector<Shot> shots=new Vector<>();

    Vector <Enemy> enemytanks=new Vector<>();

    public void setEnemytanks(Vector<Enemy> enemytanks) {
        this.enemytanks = enemytanks;
    }

    public boolean isTouchEnemyTank(){
        switch (this.getDirect()){
            case 0:
                for(int i=0;i<enemytanks.size();i++){
                    Enemy enemyTank=enemytanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                        }
                        if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1:
                for(int i=0;i<enemytanks.size();i++){
                    Enemy enemyTank=enemytanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+40
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+60){
                                return true;
                            }
                        }
                        if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()+60>=enemyTank.getX()
                                    &&this.getX()+60<=enemyTank.getX()+60
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2:
                for(int i=0;i<enemytanks.size();i++){
                    Enemy enemyTank=enemytanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+40
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+60){
                                return true;
                            }
                        }
                        if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()+40>=enemyTank.getX()
                                    &&this.getX()+40<=enemyTank.getX()+60
                                    &&this.getY()+60>=enemyTank.getY()
                                    &&this.getY()+60<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3:
                for(int i=0;i<enemytanks.size();i++){
                    Enemy enemyTank=enemytanks.get(i);
                    if(enemyTank!=this){
                        if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+60){
                                return true;
                            }
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+40
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+60){
                                return true;
                            }
                        }
                        if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()>=enemyTank.getY()
                                    &&this.getY()<=enemyTank.getY()+40){
                                return true;
                            }
                            if(this.getX()>=enemyTank.getX()
                                    &&this.getX()<=enemyTank.getX()+60
                                    &&this.getY()+40>=enemyTank.getY()
                                    &&this.getY()+40<=enemyTank.getY()+40){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }
    public Enemy(int x, int y,int direct,int speed) {
        super(x, y,direct,speed);
    }

    @Override
    public void run() {

        while(true){

            if(shots.size()<=3){
                Shot shot=null;
                switch (getDirect()){
                    case 0:
                        shot=new Shot(getX()+20,getY(),0);
                        shots.add(shot);
                        new Thread(shot).start();
                        break;
                    case 1:
                        shot=new Shot(getX()+60,getY()+20,1);
                        shots.add(shot);
                        new Thread(shot).start();
                        break;
                    case 2:
                        shot=new Shot(getX()+20,getY()+60,2);
                        shots.add(shot);
                        new Thread(shot).start();
                        break;
                    case 3:
                        shot=new Shot(getX(),getY()+20,3);
                        shots.add(shot);
                        new Thread(shot).start();
                        break;
                }
            }

            switch ((int)(Math.random()*4)){
                case 0:
                    for (int i=0;i<30;i++){
                        if(getY()>0&&!isTouchEnemyTank()){
                            moveUp();}
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:
                    for (int i=0;i<30;i++) {
                        if(getX()+60<1000&&!isTouchEnemyTank()){
                            moveRight();}
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 2:
                    for(int i=0;i<30;i++){
                        if(getY()+60<750&&!isTouchEnemyTank()){
                            moveDown();}
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:
                    for(int i=0;i<30;i++){
                        if(getX()>0&&!isTouchEnemyTank()){
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            if(isLive==false){
                break;
            }
        }
    }
}
