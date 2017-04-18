package d0418;

/**
 * StringBuilder:不是同步的append();
 * StringBuffer :是同步的synchronized append();
 */
public class StringTest {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
//        StringBuilder str = new StringBuilder();
        Thread1 thread1 = new Thread1(str);
        Thread2 thread2 = new Thread2(str);
        Thread t1 = new Thread(thread1);
        Thread t2 = new Thread(thread2);
        t1.start();
        t2.start();

    }
}

class Thread1 extends Thread {
    private StringBuffer str;
    //    private StringBuilder str;
    int i = 0;

    public Thread1(StringBuffer str) {
        this.str = str;
    }

    public void run() {
        try {
            while (i < 10) {
                i++;
                str.append("1-" + i + " ");
                System.out.println(str);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Thread2 extends Thread {
    private StringBuffer str;
    //    private StringBuilder str;
    int i = 0;

    public Thread2(StringBuffer str) {
        this.str = str;
    }

    public void run() {
        try {
            while (i < 10) {
                i++;
                str.append("2-" + i + " ");
                System.out.println(str);
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

