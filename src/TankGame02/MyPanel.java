package TankGame02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {//画板类
    //定义我的坦克
    Player player = null;

    Vector<EnemyTank> enemyTanks = new Vector<EnemyTank>();
    int enemyTankSize = 3;//敌人坦克数量

    public MyPanel() {
        this.player = new Player(100, 100);
        player.setSpeed(2);
        //初始化敌人坦克
        for(int i = 0; i < enemyTankSize; i ++){
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDire(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void paint(Graphics g) {//画坦克
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//默认游戏背景是黑色
        drawTank(player.getX(), player.getY(), g, player.getDire(), 1);//画出自己的坦克

        for(EnemyTank et : enemyTanks){
            drawTank(et.getX(), et.getY(), g, et.getDire(), 0);
        }
    }

    //编写方法画坦克
    /*
    * dire 坦克朝向，type坦克是敌是友*/
    public void drawTank(int x, int y, Graphics g, int dire, int type){
        switch(type){//0是自己的1是敌人的
            case 0://敌人的坦克
                g.setColor(Color.cyan);
                break;
            case 1://自己的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向绘制坦克
        switch(dire){ //0123 上，右，下，左
            case 0://代表向上
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的履带
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边的履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克主体
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);//坦克左边的履带
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右边的履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克主体
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的履带
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边的履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克主体
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);//坦克左边的履带
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右边的履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克主体
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }

    @Override//响应WASD操作,改变坦克方向
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            player.setDire(0);
            player.moveUp();
        }else if(e.getKeyCode() == KeyEvent.VK_S){
            player.setDire(2);
            player.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            player.setDire(3);
            player.moveLeft();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            player.setDire(1);
            player.moveRight();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
