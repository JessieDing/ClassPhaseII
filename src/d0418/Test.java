package d0418;

import java.util.Vector;

/**
 * Created by Administrator on 2017/4/18.
 */
public class Test {
    public static void main(String[] args) {
//        StringBuffer strBuf= new StringBuffer("123");
//        StringBuffer strBuf2 = new StringBuffer(strBuf);//��������

        Vector vector = new Vector();//�ٽ���Դ
        Consumer consumer = new Consumer(vector);
        Producer producer = new Producer(vector);

        Thread t_consumer = new Thread(consumer);
        Thread t_producer = new Thread(producer);

        t_consumer.start();
        t_producer.start();
    }
}

class Consumer implements Runnable {//�������̣߳�������
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
                    if (vct.size() == 0) {//������Ϊ�գ����ɶ�
                        vct.wait();//�����������ͷ��ٽ���Դ��
                        System.out.println("Consumer: after wait");
                    }
                    System.out.println(vct);//��ӡ����
                    System.out.println("before clear");
                    vct.clear();//���ѣ���ջ���������
                    System.out.println("Consumer: data cleared...");
                    vct.notify();//����д���ݵ��߳�
                    System.out.println("Consumer: obj are ready��");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Producer implements Runnable {//�������̣߳�д����
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
                        vct.wait();//�����������ݣ�����
                        System.out.println("Producer: after wait");
                    }
                    vct.add(new String("New product " + i));
                    i++;
                    vct.notify();//���Ѷ����ݵ��߳�
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
