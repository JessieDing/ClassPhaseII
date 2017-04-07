package d0407;

import java.io.*;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Test {
    public static void main(String[] args) {
        testArrayOutBound();
        testNullPointer();
        testArithmetic();
        testClassCast();
        testDataFormat();
    }

    //�����ָ���쳣
    public static void testNullPointer() {
        try {
            Bird bird = null;
            System.out.println(bird.toString());

        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }

    //��������Խ���쳣
    public static void testArrayOutBound() {
        try {
            int[] arr = new int[3];
            arr[5] = 6;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }

    //������ѧ�쳣
    public static void testArithmetic() {
        try {
            int a = 2;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }

    //����ǿ������ת���쳣
    public static void testClassCast() {
        try {
            Object x = new Integer(0);
            System.out.println((String) x);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }

    //�������ָ�ʽ���쳣
    public static void testDataFormat() {
        try {
           String str = "abc";
          System.out.println(Integer.valueOf(str));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
//            System.out.println(e.getStackTrace());
            e.printStackTrace();
        }
    }




    public static void testWriterUTF8() throws Exception {
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "testWriter.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        String str = "���ǲ����ַ�����";
        osw.write(str);
        System.out.println("д��ɹ�");
        osw.close();

    }

    public static void testReaderUTF8() throws Exception {
        FileInputStream fis = new FileInputStream("e:" + File.separator + "testWriter.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        int c = -1;
        while ((c = isr.read()) != -1) {
            System.out.print((char) c);
        }
        isr.close();
    }

    public static void testPrinterWriter() throws Exception {
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "testWriter.txt");
        PrintWriter printWriter = new PrintWriter(fos, true);//ָ����ˢ��
        printWriter.write("��һ�в���");
        printWriter.write("�ڶ��в���");
        printWriter.println("��һ��println����");//�ȼ��ڼӻ��з�
        printWriter.println("�ڶ���println����");
        printWriter.close();
    }


    public static void testBufferedReader() throws Exception {
        FileInputStream fis = new FileInputStream("e:" + File.separator + "testWriter.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        BufferedReader bufReader = new BufferedReader(isr);
        String str;
        while ((str = bufReader.readLine()) != null) {
            System.out.println(str);
        }
        bufReader.close();
    }

}

class Bird {
    private String name;

    public Bird() {
    }

    public Bird(String name) {
        this.name = name;
    }

    public String fly() {
        return "����";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                '}';
    }
}
