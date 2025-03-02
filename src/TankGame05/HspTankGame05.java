package TankGame05;

import javax.swing.*;

public class HspTankGame05 extends JFrame {
    //先定义一个MyPanel
    MyPanel mp = null;
    public static void main(String args[]){
        HspTankGame05 hspTankGame05 = new HspTankGame05();

    }
    public HspTankGame05(){
        mp = new MyPanel();

        Thread t = new Thread(mp);
        t.start();

        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
