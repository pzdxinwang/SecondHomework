import java.util.Scanner;

public class Monster {
    String name;
    int curBlood;
    int maxBlood;
    int attack;
    int defend;
    boolean isLive = true;

    public Monster(String name,int maxBlood,int attack,int defend){//手动输入的
        this.name = name;
        this.curBlood =maxBlood;
        this.attack = attack;
        this.defend = defend;
        isLive = true;
    }
    public Monster(int num){//写死的怪兽
        switch (num){
            case 1:name = "小型陈剑辉";maxBlood = 500;curBlood = 500;attack = 25;defend = 10;
            case 2:name = "中型陈剑辉";maxBlood = 200;curBlood = 200;attack = 20;defend = 40;
            case 3:name = "大型陈剑辉";maxBlood = 400;curBlood = 400;attack = 40;defend = 10;
            case 4:name = "超级无敌的陈剑辉";maxBlood = 200;curBlood = 200;attack = 30;defend = 30;
            //阿西吧我也不晓得战斗的时候为啥这里一直是超级无敌的陈剑辉，看了好久也不知道错在哪里了
        }
    }
    public void injured(Lead lead){//怪兽受伤
        int lostLife =Lostblood.calLostLife(lead.attack,this.defend);//计算损失的血量
        lead.injured(this);
        curBlood-=lostLife;
        System.out.println("怪兽"+name+"被你攻击,受到了" + lostLife+"点伤害");
        if(curBlood<=0){//小于或者等于0的血量则为死亡
            curBlood=0;
            died(lead);
        }
        printMonster();
    }
    public void died(Lead lead){
        System.out.println("------>"+name+"被打死了"+"<------");
        isLive = false;//死亡时将isLive进行修改
    }
    public void printMonster() {
        System.out.println("提示：当前怪兽信息为：" +
                "名称：" + name + "  " +
                "生命值：" + curBlood + "  " +
                "攻击力：" + attack + "  " +
                "防御力：" + defend);
    }
}
