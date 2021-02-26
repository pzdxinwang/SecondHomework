import java.util.Scanner;

public class Lead {
    String name;
    int maxBlood;
    int curBlood;
    boolean isLive;
    int attack;
    int defend;
    String equipment[] = new String[2];

    public Lead(String name,int maxBlood,int attack,int defend){//玩家手动输入的Lead
        this.name = name;
        this.curBlood =maxBlood;
        this.attack = attack;
        this.defend = defend;
        isLive = true;

    }
    public Lead(String name){//已经写死的Lead
        this.name = name;
        maxBlood = 400;
        curBlood = maxBlood;
        isLive = true;
        attack = 50;
        defend = 25;
    }

    public void printLead() {//输出角色的信息
        System.out.println("提示：当前主角信息为：" +
                "名称：" + name + "  " +
                "生命值：" + curBlood + "  " +
                "攻击力：" + attack + "  " +
                "防御力：" + defend);
    }

    public void fight(Monster monster){     //战斗
        if(monster.isLive){
            if(isLive){
                //int lostLife =Lostblood.calLostLife(this.attack,monster.defend);//计算扣血量
                monster.injured(this);//受伤
            }else{
                System.out.println("您已经阵亡！");
            }
        }else
        {
            System.out.println("怪兽"+monster.name+"已经死亡！");
        }
        printLead();
    }
    public void injured(Monster monster){   //受伤的判断
        int lostLife =Lostblood.calLostLife(monster.attack,this.defend);
        curBlood-=lostLife;
        System.out.println("主角"+this.name+"受到攻击,受到了" + lostLife+"点伤害");
        if(curBlood<=0){//判断是否死亡
            curBlood=0;
            died(monster);
        }

    }
    public void died(Monster monster){//死亡提示
        System.out.println("------"+"主角"+name+"挂掉了"+"------");
        isLive = false;
    }
}
/*这里有一个手动输入的例子可以拿来跑一跑
潘增丹
300
50
30
1
4
陈剑辉
500
35
30
 */