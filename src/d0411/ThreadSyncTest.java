package d0411;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by Administrator on 2017/4/11.
 */
public class ThreadSyncTest {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        Work1 w1 = new Work1(arr);
        Work2 w2 = new Work2(arr);
        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w2);
        t1.start();
        t2.start();
    }
}

class Work1 implements Runnable {
    int[] arr;

    public Work1(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        int tmp = 0;
        System.out.println("Thread1 executed");
        synchronized (arr) {
            while (tmp < 5) {
                try {
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] += 1;
                    }

                    System.out.println("Work1:" + Arrays.toString(arr));
                    Thread.sleep(1500);
                    tmp++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }//释放同步锁
    }
}

class Work2 implements Runnable {
    int[] arr;

    public Work2(int[] arr) {
        this.arr = arr;
    }

    public void run() {
        int tmp = 0;
        System.out.println("Thread2 executed");
        synchronized (arr) {
            while (tmp < 5) {
                try {
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] += 2;
                    }
                    System.out.println("Work2:" + Arrays.toString(arr));
                    Thread.sleep(1500);
                    tmp++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }//释放同步锁
    }
}
