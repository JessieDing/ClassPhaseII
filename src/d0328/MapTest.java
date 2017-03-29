package d0328;

import java.util.*;
/**
 * Created by Administrator on 2017/3/28.
 */
public class MapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        String pm25 = "ũչ��=423,����=378,��̨��԰=406,��̳=322,����������=398,"
                + "��԰=406,ͨ��=336,��ƽ��=248,������=306,����=231,ǰ��=422,"
                + "���ֵ�=368,�ų�=268,��ƽ��=423,������=267,����=377,ǰ��=299,"
                + "���ֵ�=285,��ˮ��=277,ũչ��=348,����=356,��̨��԰=179,��̳=277,"
                + "����������=270,��԰=268,ͨ��=315";

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


        System.out.println("��������������PM2.5���ֵ");
        System.out.println("-------------------------");
        Set<Map.Entry<String, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> m = iterator.next();
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

