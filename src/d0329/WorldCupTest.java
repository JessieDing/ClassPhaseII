package d0329;

import java.util.*;

/**
 * Created by Administrator on 2017/3/29.
 */
public class WorldCupTest {
    public static void main(String[] args) {
        HashMap<Integer, WorldCup> worldCups = new HashMap<>();
        WorldCup w1 = new WorldCup(1930, "������", "��һ��");
        WorldCup w2 = new WorldCup(1934, "�����", "�ڶ���");
        WorldCup w3 = new WorldCup(1938, "�����", "������");
        WorldCup w4 = new WorldCup(1950, "������", "���Ľ�");
        WorldCup w5 = new WorldCup(1954, "�¹�", "�����");
        worldCups.put(new Integer(1930), w1);
        worldCups.put(new Integer(1934), w2);
        worldCups.put(new Integer(1938), w3);
        worldCups.put(new Integer(1950), w4);
        worldCups.put(new Integer(1954), w5);
        System.out.println("���������");
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while ((n=scanner.nextInt()) != 0) {
            WorldCup c = worldCups.get(n);
            if (c != null) {
                System.out.println(c.toString());
            } else {
                System.out.println("�����������������");
            }
        }


        /*
        //��HashMap
        HashMap<String, String> value1 = new HashMap<>();
        value1.put("��һ��ھ�", "������");
        HashMap<String, String> value2 = new HashMap<>();
        value2.put("�ڶ���ھ�", "�����");

        HashMap<Integer, Map> map = new HashMap<>();
        map.put(1930, value1);
        map.put(1936, value2);

        System.out.println("��������ݣ�");
        Scanner scanner = new Scanner(System.in);
        Integer year = scanner.nextInt();

        if (map.containsKey(year)) {
            System.out.println(map.get(year).toString());
        }
        */


    }
}
