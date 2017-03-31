package d0329;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2017/3/31.
 */
public class RandomAccessDemo4 {
    public static void main(String[] args) throws Exception {
//        randomAccessFileTest("e:" + File.separator + "test.txt");
//        readRandomAccessFile("e:" + File.separator + "test.txt");
//        writeRandomAccessFile("e:" + File.separator + "test2.txt");
//        read2("e:" + File.separator + "test2.txt");
        seek("e:" + File.separator + "test2.txt");
    }

    public static void randomAccessFileTest(String strPath) throws Exception {
        File file = new File(strPath);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 100; i++) {
            raf.write(i);
            raf.write('\n');
            System.out.println("i=" + i + ",指针位置" + raf.getFilePointer());
        }
        raf.close();
    }


    public static void writeRandomAccessFile(String strPath) throws Exception {
        File file = new File(strPath);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        String str = "这是一个测试字符串123456789@#￥%%……！&&*（）";
        raf.write(str.getBytes("UTF-8"));
        raf.close();
    }

    public static void read2(String strPath) throws Exception {
        File file = new File(strPath);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        String tmp = "";
        while ((tmp = raf.readLine()) != null) {
            String str = new String(tmp.getBytes("ISO-8859-1"), "UTF-8");
            System.out.println(str);
        }
        raf.close();
    }

    public static void seek(String strPath) throws Exception {
        File file = new File(strPath);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        raf.seek(5);
        int temp = -1;
        byte[] bytes = new byte[1024];
        int i = 0;
        while ((temp = raf.read()) != -1) {
            byte b = (byte) temp;
            bytes[i] = b;
            i++;
        }


        raf.close();
    }


    public static void readRandomAccessFile(String strPath) throws Exception {
        File file = new File(strPath);
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        int temp = -1;
        while ((temp = raf.read()) != -1) {
            if (temp == '\n') {
                System.out.print((char) temp);
            } else {
                System.out.print("temp" + temp);
            }
        }
        raf.close();
    }

}
