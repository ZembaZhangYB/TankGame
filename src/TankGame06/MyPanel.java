package TankGame06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener,Runnable {
    Hero hero=null;
    Vector<Enemy> vector=new Vector<>();
    Vector<Bomb> bombs=new Vector<>();
    Vector<Node> nodes=new Vector<>();
    int Enemysize=3;
    private Graphics g;
    Image image1=null;
    Image image2=null;
    Image image3=null;

    public MyPanel(String key){
        //初始化图片对象
        image1=Toolkit.getDefaultToolkit().getImage("/flower.png");
        image2=Toolkit.getDefaultToolkit().getImage("/flower2.png");
        image3=Toolkit.getDefaultToolkit().getImage("/flower3.png");
        switch (key){
            case "1":
                for(int i=0;i<Enemysize;i++){
                    vector.add(new Enemy(100*(1+i),0,2,1));
                    Enemy enemytank=vector.get(i);
                    enemytank.setEnemytanks(vector);
                    Recorder.setEnemyTanks(vector);
                    new Thread(enemytank).start();
                    Shot shot=new Shot(enemytank.getX()+20,enemytank.getY()+60,enemytank.getDirect());
                    enemytank.shots.add(shot);
                    new Thread(shot).start();
                }
                hero=new Hero(750,600,0,10);
                Recorder.setHero(hero);
                break;
            //继续上局游戏
            case "2":
                nodes=Recorder.getNodesAndEnemyTankRec();
                Node nodebutton=nodes.get(3);
                if(nodebutton.getButton()==-1){
                    for(int i=0;i<Enemysize;i++){
                        vector.add(new Enemy(100*(1+i),0,2,1));
                        Enemy enemytank=vector.get(i);
                        enemytank.setEnemytanks(vector);
                        Recorder.setEnemyTanks(vector);
                        new Thread(enemytank).start();
                        Shot shot=new Shot(enemytank.getX()+20,enemytank.getY()+60,enemytank.getDirect());
                        enemytank.shots.add(shot);
                        new Thread(shot).start();
                    }
                    hero=new Hero(750,600,0,10);
                    Recorder.setHero(hero);
                    break;
                }
                for(int i=0;i<nodes.size()-1;i++) {
                    Node node = nodes.get(i);
                    vector.add(new Enemy(node.getX(), node.getY(), node.getDirect(), 1));
                    Enemy enemytank = vector.get(i);
                    enemytank.setEnemytanks(vector);
                    Recorder.setEnemyTanks(vector);
                    new Thread(enemytank).start();
                    Shot shot = new Shot(enemytank.getX() + 20, enemytank.getY() + 60, enemytank.getDirect());
                    enemytank.shots.add(shot);
                    new Thread(shot).start();
                }
                Node nodehero = nodes.get(3);
                hero=new Hero(nodehero.getX(),nodehero.getY(),nodehero.getDirect(),10);
                Recorder.setHero(hero);
                break;
            default:
                System.out.println("输入数据不合法！");
        }
    }
    public void showInfo(Graphics g){
        g.setColor(Color.black);
        Font font=new Font("宋体",Font.BOLD,25);
        g.setFont(font);
        g.drawString("您累计击毁敌方坦克",1020,30);
        drawTank(1020,60,g,0,0);
        g.setColor(Color.black);
        g.drawString(Recorder.getAllEnemyTankNum()+"",1080,100);
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        showInfo(g);
        g.fillRect(0,0,1000,750);
        if(hero.isLive) {
            drawTank(hero.getX(), hero.getY(), g, 1, hero.getDirect());
        }
        for(int i=0;i<hero.shots.size();i++){
            g.draw3DRect(hero.shots.get(i).x,hero.shots.get(i).y,1,1,false);
        }

        for(int i=0;i<bombs.size();i++){
            Bomb bomb=bombs.get(i);
            if(bomb.life>6){
                g.drawImage(image1,bomb.x,bomb.y,600,600,this);
            }else if(bomb.life>3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            } else {
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            bomb.lifeDown();
            if(bomb.life==0){
                bombs.remove(bomb);
            }
        }
        for(int i=0;i<vector.size();i++){
            if(vector.get(i).isLive){
                Enemy enemy=vector.get(i);
                drawTank(enemy.getX(),enemy.getY(),g,0,enemy.getDirect());
                for(int j=0;j<enemy.shots.size();j++){
                    Shot shot=enemy.shots.get(j);
                    if(shot.isLive){
                        g.draw3DRect(shot.x,shot.y,2,2,false);
                    }else {
                        enemy.shots.remove(shot);
                    }
                }
            }
        }

    }
    public void drawTank(int x,int y,Graphics g,int type,int direct){
        switch (type){
            case 0:
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch (direct){
            case 0:
                g.fill3DRect(x, y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y,x+20,y+30);
                break;
            case 1:
                g.fill3DRect(x, y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x+30,y+20,x+60,y+20);
                break;
            case 2:
                g.fill3DRect(x, y,10,60,false);
                g.fill3DRect(x+30,y,10,60,false);
                g.fill3DRect(x+10,y+10,20,40,false);
                g.fillOval(x+10,y+20,20,20);
                g.drawLine(x+20,y+30,x+20,y+60);
                break;
            case 3:
                g.fill3DRect(x, y,60,10,false);
                g.fill3DRect(x,y+30,60,10,false);
                g.fill3DRect(x+10,y+10,40,20,false);
                g.fillOval(x+20,y+10,20,20);
                g.drawLine(x,y+20,x+30,y+20);
                break;
        }
    }

    //编写方法，判断我方坦克是否击中敌人坦克
    public void hiteTank(Shot s,Tank enemytank){
        switch (enemytank.getDirect()){
            case 0:
            case 2:
                if(s.x>enemytank.getX()&&s.x<enemytank.getX()+40 &&
                        s.y>enemytank.getY()&&s.y<enemytank.getY()+60&& enemytank.isLive){
                    s.isLive=false;
                    enemytank.isLive=false;
                    vector.remove(enemytank);
                    if(enemytank instanceof Enemy){
                        Recorder.addAllEnemyTankNum();
                        if(vector.size()<3){
                            vector.add(new Enemy((int)(Math.random()*900),(int)(Math.random()*700),2,1));
                            Enemy enemytank1=vector.get(2);
                            enemytank1.setEnemytanks(vector);
                            Recorder.setEnemyTanks(vector);
                            new Thread(enemytank1).start();
                            Shot shot=new Shot(enemytank1.getX()+20,enemytank1.getY()+60,enemytank1.getDirect());
                            enemytank1.shots.add(shot);
                            new Thread(shot).start();
                        }
                    }
                    if(enemytank instanceof Hero){
                        System.out.println("游戏结束，你累计击毁了"+Recorder.getAllEnemyTankNum()+"个坦克");
                        Recorder.setAllEnemyTankNum(0);
                        Recorder.keepRecord();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.exit(0);
                    }
                    Bomb bomb=new Bomb(enemytank.getX(),enemytank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if(s.x>enemytank.getX()&&s.x< enemytank.getX()+60&&
                        s.y>enemytank.getY()&&s.y<enemytank.getY()+40&&enemytank.isLive){
                    s.isLive=false;
                    enemytank.isLive=false;
                    vector.remove(enemytank);
                    if(enemytank instanceof Enemy){
                        Recorder.addAllEnemyTankNum();
                        if(vector.size()<3){
                            vector.add(new Enemy((int)(Math.random()*400)+100,(int)(Math.random()*200)+100,2,1));
                            Enemy enemytank1=vector.get(2);
                            enemytank1.setEnemytanks(vector);
                            Recorder.setEnemyTanks(vector);
                            new Thread(enemytank1).start();
                            Shot shot=new Shot(enemytank1.getX()+20,enemytank1.getY()+60,enemytank1.getDirect());
                            enemytank1.shots.add(shot);
                            new Thread(shot).start();
                        }
                    }
                    if(enemytank instanceof Hero){
                        System.out.println("游戏结束，你累计击毁了"+Recorder.getAllEnemyTankNum()+"个坦克");
                        Recorder.setAllEnemyTankNum(0);
                        Recorder.keepRecord();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.exit(0);
                    }
                    Bomb bomb=new Bomb(enemytank.getX(),enemytank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }
    public void hiteEnemyTank(){
        //判断是否击中敌人坦克
        for(int i=0;i<hero.shots.size();i++){
            Shot shot=hero.shots.get(i);
            if(shot.isLive&&shot!=null){
                for(int j=0;j<vector.size();j++){
                    Enemy enemyTank=vector.get(j);
                    hiteTank(shot,enemyTank);
                }
            }else{
                hero.shots.remove(i);
            }
        }
    }

    public void hiteHeroTank(){
        for(int i=0;i<vector.size();i++){
            Enemy enemytank=vector.get(i);
            for (int j=0;j<enemytank.shots.size();j++){
                Shot shot=enemytank.shots.get(j);
                if(shot!=null&&shot.isLive){
                    hiteTank(shot,hero);
                }else {
                    enemytank.shots.remove(j);
                }
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_W){
            if(hero.getY()>0){
                hero.moveUp();}
            this.repaint();
        } else if (e.getKeyCode()==KeyEvent.VK_D) {
            if(hero.getX()<940){
                hero.moveRight();}
            this.repaint();
        } else if (e.getKeyCode()==KeyEvent.VK_S) {
            if(hero.getY()<690){
                hero.moveDown();}
            this.repaint();
        } else if (e.getKeyCode()==KeyEvent.VK_A) {
            if(hero.getX()>0){
                hero.moveLeft();}
            this.repaint();
        }
        if(e.getKeyCode()==KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            for(int l=0;l<vector.size();l++){
                Enemy enemytank=vector.get(l);
                if(!enemytank.isLive){
                    vector.remove(enemytank);
                }
            }
            hiteEnemyTank();
            hiteHeroTank();
            this.repaint();
        }
    }
}
