package TankGame06;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class TankGame06 extends JFrame {
    static Scanner scanner=new Scanner(System.in);
    private MyPanel mp=null;
    public static void main(String[] args) {
        new TankGame06();
    }

    public TankGame06(){
        System.out.println("请输入你的选择>:");
        System.out.println("1. 开启新游戏        2. 继续上局游戏");
        String key=scanner.next();
        mp=new MyPanel(key);
        Thread thread=new Thread(mp);
        thread.start();
        this.add(mp);
        this.setSize(1300,800);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.keepRecord();
                System.exit(0);
            }
        });
    }
}
