import java.util.Scanner;

public class GameStart {
    Lead lead1,lead2;
    Monster m1,m2,m3,m4,m5;
/*
    public GameStart(){//手动输入主角和怪兽的信息
        System.out.println("**********");
        System.out.println("请先输入主角的各项信息：");
        System.out.println("**********");

        System.out.println("请输入主角名称：");
        Scanner leadName = new Scanner(System.in);
        String name1 = leadName.next();

        System.out.println("请输入主角的初始生命值：");
        Scanner leadBlood = new Scanner(System.in);
        int maxBlood1 = leadBlood.nextInt();

        System.out.println("请输入主角的攻击力：");
        Scanner leadAttack = new Scanner(System.in);
        int attack1 = leadBlood.nextInt();

        System.out.println("请输入主角的防御力：");
        Scanner leadDefend = new Scanner(System.in);
        int defend1 = leadDefend.nextInt();

        System.out.println("输入怪兽的名字，血量，攻击力，防御力");
        Scanner scanner1 = new Scanner(System.in);
        String name2 = scanner1.next();

        Scanner scanner2 = new Scanner(System.in);
        int maxBl00d2 = scanner2.nextInt();

        Scanner scanner3 = new Scanner(System.in);
        int attack2 = scanner3.nextInt();

        Scanner scanner4 = new Scanner(System.in);
        int defend2 = scanner4.nextInt();

        lead1 = new Lead(name1,maxBlood1,attack1,defend1);//手动所创建的主角和怪兽
        m1 = new Monster(name2,maxBl00d2,attack2,defend2);

        lead2 = new Lead("潘增丹");//怪兽和主角是写死的，一对多随机作战
        m2 = new Monster(1);
        m3 = new Monster(2);
        m4 = new Monster(3);
        m5 = new Monster(4);



        Equipment.chooseEquipment();
        System.out.println("------开始战斗！------");
    }*/

    public void start(){//开始游戏
        System.out.println("你想要那种战斗：【0】手动输入信息战斗 【1】系统生成一对多");
        Scanner scanner = new Scanner(System.in);
        int ch = scanner.nextInt();
        if (ch == 1){//系统生成的一对多（自己写死的）
            lead2 = new Lead("潘增丹");//怪兽和主角是写死的，一对多随机作战
            m2 = new Monster(1);
            m3 = new Monster(2);
            m4 = new Monster(3);
            m5 = new Monster(4);

            System.out.println("------开始战斗！------");
            while(lead2.isLive && (m2.isLive|| m3.isLive|| m4.isLive|| m5.isLive)){
                int ran = Lostblood.RandomRange(4);//这里是想实现一对多的功能，战斗方式是随机random一个来进行战斗
                switch (ran){
                    case 1:lead2.fight(m2);  break;
                    case 2:lead2.fight(m3);  break;
                    case 3:lead2.fight(m4);  break;
                    case 4:lead2.fight(m5);  break;
                    default: System.out.println("------怪兽害怕得全藏起来了，再次寻找------");
                }
                if (lead2.isLive && (m2.isLive|| m3.isLive|| m4.isLive|| m5.isLive))//如果还有一方存活，就输出继续战斗
                    System.out.println("------战斗继续！------");
            }
            end2();
        }
        else if (ch == 0){//手动输入信息的
            System.out.println("**********");
            System.out.println("请先输入主角的各项信息：");
            System.out.println("**********");

            System.out.println("请输入主角名称：");
            Scanner leadName = new Scanner(System.in);
            String name1 = leadName.next();

            System.out.println("请输入主角的初始生命值：");
            Scanner leadBlood = new Scanner(System.in);
            int maxBlood1 = leadBlood.nextInt();

            System.out.println("请输入主角的攻击力：");
            Scanner leadAttack = new Scanner(System.in);
            int attack1 = leadBlood.nextInt();

            System.out.println("请输入主角的防御力：");
            Scanner leadDefend = new Scanner(System.in);
            int defend1 = leadDefend.nextInt();

            System.out.println("输入怪兽的名字，血量，攻击力，防御力");
            Scanner scanner1 = new Scanner(System.in);
            String name2 = scanner1.next();

            Scanner scanner2 = new Scanner(System.in);
            int maxBl00d2 = scanner2.nextInt();

            Scanner scanner3 = new Scanner(System.in);
            int attack2 = scanner3.nextInt();

            Scanner scanner4 = new Scanner(System.in);
            int defend2 = scanner4.nextInt();

            lead1 = new Lead(name1,maxBlood1,attack1,defend1);//手动所创建的主角和怪兽
            m1 = new Monster(name2,maxBl00d2,attack2,defend2);

            Equipment.chooseEquipment();//选择装备
            System.out.println("------开始战斗！------");

            while(lead1.isLive && m1.isLive){
                lead1.fight(m1);//战斗
            if (lead1.isLive && m1.isLive)
                System.out.println("------战斗继续！------");
            }
            end();
        }
        else System.out.println("输入错误！");
    }

    public void end(){//手动战斗的游戏结束提示
        if(lead1.isLive){//如果已经死亡
            System.out.println("游戏结束，成功打死怪兽救出公主~~~");
        }else{
            System.out.println("怪兽太厉害了，公主没救出来就死了~~~");
        }
    }
    public void end2(){//自动战斗的游戏结束
        if (lead2.isLive){
            System.out.println("游戏结束，成功打死怪兽救出公主~~~");
        }else{
            System.out.println("怪兽太厉害了，公主没救出来就死了~~~");
        }
    }
}
