package d0418;

import java.util.Vector;

/**
 * Created by Administrator on 2017/4/18.
 */
public class Test {
    public static void main(String[] args) {
//        StringBuffer strBuf= new StringBuffer("123");
//        StringBuffer strBuf2 = new StringBuffer(strBuf);//拷贝构造

        Vector vector = new Vector();//临界资源
        Consumer consumer = new Consumer(vector);
        Producer producer = new Producer(vector);

        Thread t_consumer = new Thread(consumer);
        Thread t_producer = new Thread(producer);

        t_consumer.start();
        t_producer.start();
    }
}

class Consumer implements Runnable {//消费者线程，读数据
    private Vector vct;

    public Consumer(Vector vct) {
        this.vct = vct;
    }

    public void run() {
        synchronized (vct) {
            System.out.println("Consumer:enter synchronized...");
            while (true) {
                System.out.println("Consumer:enter while");
                try {
                    if (vct.size() == 0) {//缓冲区为空，不可读
                        vct.wait();//阻塞，并且释放临界资源锁
                        System.out.println("Consumer: after wait");
                    }
                    System.out.println(vct);//打印内容
                    System.out.println("before clear");
                    vct.clear();//消费，清空缓冲区内容
                    System.out.println("Consumer: data cleared...");
                    vct.notify();//唤醒写数据的线程
                    System.out.println("Consumer: obj are ready！");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Producer implements Runnable {//生产者线程，写数据
    private Vector vct;
    int i = 0;

    public Producer(Vector vct) {
        this.vct = vct;
    }

    public void run() {
        synchronized (vct) {
            System.out.println("Producer: enter synchronized");
            try {
                while (true) {
                    System.out.println("Producer: enter while");
                    if (vct.size() != 0) {
                        vct.wait();//缓冲区有数据，阻塞
                        System.out.println("Producer: after wait");
                    }
                    vct.add(new String("New product " + i));
                    i++;
                    vct.notify();//唤醒读数据的线程
                    System.out.println("Producer: obj are ready!");
                    Thread.sleep(500);
                    System.out.println("sleep 500s...");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
