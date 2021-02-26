import java.util.Random;

public class Lostblood {
    public static int calLostLife(int attack,int defend){
        int lostLife = attack-defend;
        int LeastBlood = 1;//最少扣一滴血
        int real = 0;
        if(lostLife<=0){
            real = LeastBlood;
        }else{
            real = lostLife;
        }
        return real;
    }
    public static int RandomRange(int num){//产生随机数
        Random random = new Random();
        return (int)(random.nextInt(num)+1);
    }
}

