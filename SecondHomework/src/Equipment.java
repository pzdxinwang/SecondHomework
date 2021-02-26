import java.util.ArrayList;
import java.util.Scanner;

public class Equipment {
    public static void chooseEquipment(){//选择装备
        System.out.println("装备选项还没设计好，随便选两个不影响");

        System.out.println("请按顺序选择需要的两件装备：");
        ArrayList<String> equipmentList = new ArrayList<>();//装备列表
        equipmentList.add("销魂剑");
        equipmentList.add("凌弱弓");
        equipmentList.add("无畏刃");
        equipmentList.add("金钟罩");
        equipmentList.add("死守甲");
        System.out.println(equipmentList);

        System.out.println("【1】销魂剑：+10攻击力");//装备详细信息列表
        System.out.println("【2】凌弱弓：若主角攻击力高于对方防御力，造成伤害+5");
        System.out.println("【3】无畏刃：若主角攻击力低于对方防御力，造成伤害+10");
        System.out.println("【4】金钟罩：防御力+15");
        System.out.println("【5】死守甲：若敌方攻击力高于主角防御力，造成伤害-5" );

        Scanner ch1 = new Scanner(System.in);
        int c1 = ch1.nextInt();
        Scanner ch2 = new Scanner(System.in);
        int c2 = ch2.nextInt();

        ArrayList<String> equipmentChoose = new ArrayList<>();//获取装备
        equipmentChoose.add(equipmentList.get(c1-1));
        equipmentChoose.add(equipmentList.get(c2-1));
        System.out.println("您选择的装备为：");
        System.out.println(equipmentChoose);

    }
}
