package d0331;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Administrator on 2017/3/31.
 */
public class IOTest {
    public static void main(String[] args) {
        try {
//            testFOS();
//            testFIS();
//            testCopyFile();
            testBOS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  /*
  *   public static void testFOS() throws Exception {
        File file = new File("e:" + File.separator + "test.txt");
        FileOutputStream fos = new FileOutputStream(file, true);
//        FileOutputStream fos = new FileOutputStream("e:"+ File.separator+"test.txt");
        fos.write("Hello, I'm FileOutputStream...".getBytes());
        fos.close();
    }

    public static void testFIS() throws Exception {
        File file = new File("e:" + File.separator + "test.txt");
        FileInputStream fis = new FileInputStream(file);
        int tmp = -1;
        while ((tmp = fis.read()) != -1) {
            System.out.print((char) tmp);
        }
        fis.close();
    }
  * */

    public static void testCopyFile() throws Exception {
        FileInputStream fis = new FileInputStream("e:" + File.separator + "fos.txt");
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "foscopy.txt");
        int len = -1;
        byte[] buf = new byte[32];
        while ((len = fis.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        System.out.println("复制完毕");
        fos.close();
        fis.close();
    }

    public static void testBOS() throws Exception {
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "fos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("BufferedOutputStream test message.".getBytes());
        bos.flush();//显示写入
        bos.close();
    }
}
