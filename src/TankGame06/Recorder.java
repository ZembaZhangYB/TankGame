package TankGame06;

import java.io.*;
import java.util.Vector;

public class Recorder {
    private static int allEnemyTankNum=0;
    private static BufferedWriter bw=null;
    private static BufferedReader br=null;
    private static String recordFile="src\\myRecord.txt";
    private static Vector<Enemy> enemyTanks =null;
    private static Hero hero=null;
    private static Vector<Node> nodes=new Vector<>();
    public static Vector<Node> getNodesAndEnemyTankRec(){
        try {
            br=new BufferedReader(new FileReader(recordFile));
            allEnemyTankNum = Integer.parseInt(br.readLine());
            String line=null;
            while ((line =br.readLine())!=null){
                String[] xyd=line.split(" ");
                if(xyd.length>=3){
                    Node node=new Node(Integer.parseInt(xyd[0]),Integer.parseInt(xyd[1]),Integer.parseInt(xyd[2]));
                    nodes.add(node);
                } else if (xyd.length==1) {
                    Node node=new Node(Integer.parseInt(xyd[0]));
                    nodes.add(node);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(br!=null){
                    br.close();}
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return nodes;
    }

    public static void setEnemyTanks(Vector<Enemy> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }
    //当游戏退出时，保存击毁敌方坦克数以及敌人坦克的坐标和方向。
    public static void keepRecord() {
        try {
            bw=new BufferedWriter(new FileWriter(recordFile));
            bw.write(allEnemyTankNum+"\r\n");
            if(enemyTanks!=null){
                for(int i=0;i<enemyTanks.size();i++){
                    Enemy enemyTank=enemyTanks.get(i);
                    if(enemyTank.isLive){
                        String record=enemyTank.getX()+" "+enemyTank.getY()+" "+enemyTank.getDirect();
                        bw.write(record+"\r\n");
                    }
                }
            }
            if(hero!=null){
                if(hero.isLive==true) {
                    String record = hero.getX() + " " + hero.getY() + " " + hero.getDirect();
                    bw.write(record + "\r\n");
                }else if(hero.isLive==false) {
                    bw.write("-1");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static int getAllEnemyTankNum() {
        return allEnemyTankNum;
    }

    public static void setAllEnemyTankNum(int allEnemyTankNum) {
        Recorder.allEnemyTankNum = allEnemyTankNum;
    }
    public static void addAllEnemyTankNum(){
        Recorder.allEnemyTankNum++;
    }

    public static Hero getHero() {
        return hero;
    }

    public static void setHero(Hero hero) {
        Recorder.hero = hero;
    }
}
