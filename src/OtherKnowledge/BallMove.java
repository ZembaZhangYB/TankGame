package OtherKnowledge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BallMove extends JFrame{//用键盘控制小球移动
    MyPanel mp = new MyPanel();

    public static void main(String[] args) {
        new BallMove();
    }

    public BallMove(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(500, 500);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel implements KeyListener{
    int x = 10, y = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {//监听到的按键是↓键
            y ++;
        } else if(e.getKeyCode() == KeyEvent.VK_UP){
            y --;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT){
            x --;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            x ++;
        }
        //位置改变，重绘小球
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 不需要实现
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 不需要实现
    }
}