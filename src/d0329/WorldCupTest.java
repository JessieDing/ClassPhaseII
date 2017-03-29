package d0329;

import java.util.*;

/**
 * Created by Administrator on 2017/3/29.
 */
public class WorldCupTest {
    public static void main(String[] args) {
        HashMap<Integer, WorldCup> worldCups = new HashMap<>();
        WorldCup w1 = new WorldCup(1930, "乌拉圭", "第一届");
        WorldCup w2 = new WorldCup(1934, "意大利", "第二届");
        WorldCup w3 = new WorldCup(1938, "意大利", "第三届");
        WorldCup w4 = new WorldCup(1950, "乌拉圭", "第四届");
        WorldCup w5 = new WorldCup(1954, "德国", "第五届");
        worldCups.put(new Integer(1930), w1);
        worldCups.put(new Integer(1934), w2);
        worldCups.put(new Integer(1938), w3);
        worldCups.put(new Integer(1950), w4);
        worldCups.put(new Integer(1954), w5);
        System.out.println("请输入年份");
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while ((n=scanner.nextInt()) != 0) {
            WorldCup c = worldCups.get(n);
            if (c != null) {
                System.out.println(c.toString());
            } else {
                System.out.println("年份有误，请重新输入");
            }
        }


        /*
        //用HashMap
        HashMap<String, String> value1 = new HashMap<>();
        value1.put("第一届冠军", "乌拉圭");
        HashMap<String, String> value2 = new HashMap<>();
        value2.put("第二届冠军", "意大利");

        HashMap<Integer, Map> map = new HashMap<>();
        map.put(1930, value1);
        map.put(1936, value2);

        System.out.println("请输入年份：");
        Scanner scanner = new Scanner(System.in);
        Integer year = scanner.nextInt();

        if (map.containsKey(year)) {
            System.out.println(map.get(year).toString());
        }
        */


    }
}
