package TankGame04;

import javax.swing.*;

public class HspTankGame04 extends JFrame {
    //先定义一个MyPanel
    MyPanel mp = null;
    public static void main(String args[]){
        HspTankGame04 hspTankGame04 = new HspTankGame04();

    }
    public HspTankGame04(){
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
