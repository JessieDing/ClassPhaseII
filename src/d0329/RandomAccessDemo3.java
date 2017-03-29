package d0329;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2017/3/29.
 */
public class RandomAccessDemo3 {
    public static void main(String[] args) throws Exception {
        File file = new File("e:" + File.separator + "JavaDemo" + File.separator + "test.txt");
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        System.out.println("文件指针位置1：" + raf.getFilePointer());
        String string = "hello!";
        raf.writeBytes(string);
        System.out.println("文件指针位置2：" + raf.getFilePointer());

        File pic = new File("e:" + File.separator + "JavaDemo" + File.separator + "test.bmp");
        RandomAccessFile rdPic = new RandomAccessFile(pic, "rw");
        rdPic.skipBytes(54);

        while (true) {
            int i = rdPic.read();
            raf.seek(raf.getFilePointer() - 1);
            raf.write(255 - i);
            if (rdPic.getFilePointer() >= rdPic.length() - 1) {
                break;
            }
        }
        System.out.println("文件指针位置：" + rdPic.getFilePointer());
    }
}
