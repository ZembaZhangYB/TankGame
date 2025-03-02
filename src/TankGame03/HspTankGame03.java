package TankGame03;

import javax.swing.*;

public class HspTankGame03 extends JFrame {
    //先定义一个MyPanel
    MyPanel mp = null;
    public static void main(String args[]){
        HspTankGame03 hspTankGame03 = new HspTankGame03();

    }
    public HspTankGame03(){
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
