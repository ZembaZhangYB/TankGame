package TankGame05;

public class Shot implements Runnable {
    private boolean isLive = true;//子弹是否存活

    int x;
    int y;//xy坐标
    int dire = 0;
    private int speed = 5;

    public Shot(int x, int y, int dire) {
        this.x = x;
        this.y = y;
        this.dire = dire;
    }

    public boolean getIsLive() {
        return isLive;
    }
    public void setIsLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {//射击行为 即改变横纵坐标
        while (true) {
            //线程休眠，让子弹飞一会
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switch (dire) {
                case 0://子弹向上飞，0123上右下左
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            //System.out.printf("子弹坐标（%d, %d)\n", x, y);
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)){
                isLive = false;
                break;//此时碰到了边界
            }
        }
    }
}
