package d0329;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/3/29.
 */
public class TimeCompare {


    public static void main(String[] args) {
        List<Long> arrList = new ArrayList<>();
        List<Long> linkedList = new LinkedList<>();

        for (int i = 0; i < 100000; i++) {
            arrList.add(new Long(i));
        }
        prtSysTime(); //arrList的添加完成时间（查找开始时间）
        for (int i = 0; i < 100000; i++) {
            arrList.get(i);
        }
        prtSysTime();//arrList的查找完成时间
        for (int i = 0; i < 100000; i++) {
            linkedList.add(new Long(i));
        }
        prtSysTime();//LinkedList的添加完成时间（查找开始时间）
        for (int i = 0; i < 100000; i++) {
            linkedList.get(i);
        }
        prtSysTime();//LinkedList的查找完成时间



    }

    public static void prtSysTime() {
        Date now = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
        System.out.println(df.format(now));
    }
}
