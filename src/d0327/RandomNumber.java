package d0327;

/**
 * Created by Administrator on 2017/3/27.
 */
public class RandomNumber {
    public static void main(String[] args) {
        int lens = 10;
        int count = 0;

        int[] arr = new int[lens];
        for (int i = 0; i < lens; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < lens; i++) {
            int next = (int) (Math.random() * i);
            count++;
            int temp = arr[i];
            arr[i] = arr[next]; //产生随机数,随机数做下标对应的元素数值即该随机数，放到i位置
            arr[next] = temp;
        }

        int[] newArr = new int[lens];
        for (int i : arr) {//乱序旧数组
            newArr[i] = i;//填到新数组
        }

        for (int i : newArr) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(count);
    }
}
