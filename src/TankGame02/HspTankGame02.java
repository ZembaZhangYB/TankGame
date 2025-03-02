package TankGame02;

import javax.swing.*;

public class HspTankGame02 extends JFrame {
    //先定义一个MyPanel
    MyPanel mp = null;
    public static void main(String args[]){
        HspTankGame02 hspTankGame02 = new HspTankGame02();

    }
    public HspTankGame02(){
        mp = new MyPanel();
        this.add(mp);
        this.setSize(1000, 750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
