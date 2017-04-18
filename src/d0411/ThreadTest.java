package d0411;

/**
 * Created by Administrator on 2017/4/11.
 */
public class ThreadTest {
    public static void main(String[] args) {
//        TestThread t1 = new TestThread("这是第一个线程线程线程", 1000, 10);
//        t1.start();
//        TestThread t2 = new TestThread("这是第二个线程", 3000, 10);
//        t2.start();
//        MyThread t3 = new MyThread();
//        t3.start();
//        Run1 run1 = new Run1();
//        Thread t1 = new Thread(run1);
//        t1.start();

        Thread1 t1 = new Thread1(5);
        Thread2 t2 = new Thread2(5);
        t1.start();
        try{
            t1.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("==================");
        t2.start();
//        printThreadInfo(t1);
    }


    //打印进程信息
    public static void printThreadInfo(Thread t) {
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        System.out.println(t.isAlive());
        System.out.println(t.isDaemon());
        System.out.println(t.isInterrupted());
    }
}


//线程1：接收一个整数n,创建一个线程计算从1+2+…+n并输出结果
class Thread1 extends Thread {
    int number;

    public Thread1(int number) {
        this.number = number;
    }

    public void run() {
        int i = 1;
        int sum = 0;
        while (i < number) {
            sum += i;
            System.out.println(sum);
            i++;
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


//线程2：每隔一秒在控制台输出：“我是一个线程，正在输出第*个hello world!”
class Thread2 extends Thread {
    int num;

    public Thread2(int num) {
        this.num = num;
    }

    public void run() {
        int i = 1;
        while (i < num) {
            System.out.println("我是一个线程，正在输出第" + i + "个hello world。");
            i++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class TestThread extends Thread {
    String message;
    int sleepTime;
    int workTimes;

    public TestThread(String message, int sleepTime, int workTimes) {
        this.message = message;
        this.sleepTime = sleepTime;
        this.workTimes = workTimes;
    }

    public void run() {
        int i = 0;
        while (i < workTimes) {
            System.out.println(message);
            i++;
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    public void run() {
        int num = 0;
        try {
            for (int i = 0; i < 20; i++) {
                num += i;
            }

            System.out.println("num:" + num);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Run1 implements Runnable {
    public void run() {
        int i = 0;
        while (i < 10) {
            System.out.println("Run1......");
            i++;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
