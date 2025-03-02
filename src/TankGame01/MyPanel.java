package TankGame01;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    //定义我的坦克
    Player player = null;

    public MyPanel() {
        this.player = new Player(100, 100);
    }

    @Override
    public void paint(Graphics g) {//画坦克
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//默认游戏背景是黑色
        drawTank(player.getX(), player.getY(), g, 0, 1);
    }

    //编写方法画坦克
    /*
    * dire 坦克朝向，type坦克是敌是友*/
    public void drawTank(int x, int y, Graphics g, int dire, int type){
        switch(type){//0是自己的1是敌人的
            case 0://我们的坦克
                g.setColor(Color.cyan);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克方向绘制坦克
        switch(dire){
            case 0:
                g.fill3DRect(x, y, 10, 60, false);//坦克左边的履带
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边的履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克主体
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            default:
                System.out.println("暂时没有处理");
        }
    }
}
