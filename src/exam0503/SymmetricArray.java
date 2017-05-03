package exam0503;

/**
 * Created by dell on 2017/5/3.
 */
public class SymmetricArray {
    public static void main(String[] args) {
//        int[] arr = {1, 4, 5, 6, 6, 5, 4, 3};
//        int[] arr = {1, 4, 5, 6, 7, 8, 7, 6, 5, 4, 1};
        int[] arr = {1, 4, 5, 6, 7, 8, 9, 10, 7, 6, 5, 4, 1};
        System.out.println("Is this array symmetric?");
        System.out.println(isSymmetricArr(arr));
    }

    public static boolean isSymmetricArr(int[] arr) {
        boolean flag = true;

        int lens = arr.length;
        if (lens % 2 != 0) {
            //数组长度为奇数
            int n = lens / 2;
            for (int i = 1; i <= n; i++) {
                if (arr[n - i] != arr[n + i]) {
                    flag = false;
                    break;
                }
            }
        } else {
            //数组长度为偶数
            int n = (lens - 1) / 2;
            for (int i = 0; i <= n; i++) {
                if (arr[n - i] != arr[(lens / 2) + i]) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}
