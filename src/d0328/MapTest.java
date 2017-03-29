package d0328;

import java.util.*;
/**
 * Created by Administrator on 2017/3/28.
 */
public class MapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        String pm25 = "农展馆=423,东四=378,丰台花园=406,天坛=322,海淀区万柳=398,"
                + "官园=406,通州=336,昌平镇=248,怀柔镇=306,定陵=231,前门=422,"
                + "永乐店=368,古城=268,昌平镇=423,怀柔镇=267,定陵=377,前门=299,"
                + "永乐店=285,秀水街=277,农展馆=348,东四=356,丰台花园=179,天坛=277,"
                + "海淀区万柳=270,官园=268,通州=315";

        String[] pmArr = pm25.split(",|=");//split("[,=]")
        for (int i = 0; i < pmArr.length; i += 2) {
//            System.out.println(pmArr[i]);
            if (map.containsKey(pmArr[i])) {
                int oldValue = Integer.parseInt(map.get(pmArr[i]));
                int newValue = Integer.parseInt(pmArr[i + 1]);
                int tmp = oldValue > newValue ? oldValue : newValue;
                String putValue = String.valueOf(tmp);
                map.put(pmArr[i], putValue);

            } else {
                map.put(pmArr[i], pmArr[i + 1]);
            }
        }
        /*
        * for(int i=0;i<arr.length;i+=2){
			if(!map.containsKey(arr[i])||Integer.parseInt(arr[i+1])>map.get(arr[i])){
				   map.put(arr[i], Integer.parseInt(arr[i+1]));
			}
		}
		System.out.println(map);
        *
        */


        System.out.println("各空气质量监测点PM2.5最高值");
        System.out.println("-------------------------");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> m = iterator.next();
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

