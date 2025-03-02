package TankGame05;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

//为了实现子弹能够被频繁重绘以展示其轨迹，需要将这个设计为线程子类
public class MyPanel extends JPanel implements KeyListener, Runnable {//画板类
    //定义我的坦克
    Player player = null;

    Vector<EnemyTank> enemyTanks = new Vector<EnemyTank>();
    Vector<Bomb> bs = new Vector<>();//每当子弹击中坦克，加一个bomb对象
    int enemyTankSize = 3;//敌人坦克数量

    //定义炸弹的图片，显示爆炸效果
    Image im1 = null;

    public MyPanel() {
        this.player = new Player(100, 100);
        player.setSpeed(2);
        //初始化敌人坦克
        for(int i = 0; i < enemyTankSize; i ++){
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            enemyTank.setDire(2);

            new Thread(enemyTank).start();
            //给enemy加入一颗子弹
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDire());
            enemyTank.shots.add(shot);
            //启动 shot 对象
            new Thread(shot).start();

            enemyTanks.add(enemyTank);

        }
        //初始化图片对象
        im1 = Toolkit.getDefaultToolkit().getImage("flower.png");
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750); // 默认游戏背景是黑色

        drawTank(player.getX(), player.getY(), g, player.getDire(), 1); // 画出自己的坦克

        // 画出player打出的子弹
        if (player.getShot() != null && player.getShot().getIsLive() == true) {
            g.fillOval(player.getShot().x - 2, player.getShot().y - 2, 5, 5);
        }

        for(Shot s : player.shots){
            if(s != null && s.getIsLive()){
                g.draw3DRect(s.x, s.y, 1, 1, false);
            }else player.shots.remove(s);
        }

        // 如果bs中有炸弹，就画出爆炸效果
        for (Bomb b : bs) {
            if (b.life > 6) g.drawImage(im1, b.x, b.y, 60, 60, this);
            else if (b.life > 3) g.drawImage(im1, b.x, b.y, 50, 50, this);
            else g.drawImage(im1, b.x, b.y, 20, 20, this);

            b.lifeDown();
            // 如果bomb.life = 0,从集合中删除
            if (b.life == 0) bs.remove(b);
        }

        for (EnemyTank et : enemyTanks) {
            if (et.isLive) {
                drawTank(et.getX(), et.getY(), g, et.getDire(), 0); // 绘制敌人坦克
                for (Shot st : et.shots) {
                    if (st.getIsLive()) {
                        g.fillOval(st.x - 2, st.y - 2, 5, 5); // 绘制敌人子弹
                    } else {
                        et.shots.remove(st);
                    }
                }
            } else {
                enemyTanks.remove(et); // 移除死亡的敌人坦克
            }
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
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边的履带
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的履带
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

    //判断子弹是否击中了敌方坦克
    // 判断子弹是否击中了敌方坦克
    public void hitTank(Shot s, EnemyTank enemyTank){
        if (!enemyTank.isLive) return;  // 确保只检测活着的敌人坦克

        switch (enemyTank.getDire()) {
            case 0:
            case 1:
            case 2:
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 40 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 60) {
                    s.setIsLive(false);  // 子弹消失
                    enemyTank.isLive = false;  // 敌人坦克消失
                    //创建一个Bomb对象加入进bs
                    bs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                }
                break;
            case 3:
                if(s.x > enemyTank.getX() && s.x < enemyTank.getX() + 60 && s.y > enemyTank.getY() && s.y < enemyTank.getY() + 40) {
                    s.setIsLive(false);  // 子弹消失
                    enemyTank.isLive = false;  // 敌人坦克消失
                    bs.add(new Bomb(enemyTank.getX(), enemyTank.getY()));
                }
                break;
        }
    }



    @Override//响应WASD操作,改变坦克方向
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W){
            player.setDire(0);
            if(player.getY() > 0)player.moveUp();

        }else if(e.getKeyCode() == KeyEvent.VK_S){
            player.setDire(2);
            if(player.getX() + 60 < 1000) player.moveDown();
        }else if(e.getKeyCode() == KeyEvent.VK_A){
            player.setDire(3);
            if(player.getY() + 60< 750)player.moveLeft();
        }else if(e.getKeyCode() == KeyEvent.VK_D){
            player.setDire(1);
            if(player.getX() > 0) player.moveRight();
        }

        if(e.getKeyCode() == KeyEvent.VK_J){//为什么不和上面一起else？因为不是不能共存的关系
            //判断player的子弹是否消亡
            if(player.getShot() == null && !player.getShot().getIsLive()){
                player.shotEnemy();
            }
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (player.getShot().getIsLive()) {
                for (EnemyTank et : enemyTanks) {
                    hitTank(player.getShot(), et);  // 检测敌人是否被击中
                }
            }

            // 删除已消失的敌人坦克
            enemyTanks.removeIf(et -> !et.isLive);

            this.repaint();  // 重绘面板
        }
    }

}
