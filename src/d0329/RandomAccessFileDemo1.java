package d0329;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2017/3/29.
 */
public class RandomAccessFileDemo1 {
    public static void main(String args[]) throws Exception {
        //在主方法处使用throws抛出异常给JVM处理，节省了很多异常处理操作
        File f = new File("e:" + File.separator + "test.txt");    // 指定要操作的文件
        RandomAccessFile rdf = null;        // 声明RandomAccessFile类的对象
        rdf = new RandomAccessFile(f, "rw");// 读写模式，如果文件不存在，会自动创建
        String name = null;
        int age = 0;
        name = "zhangsan";            // 字符串长度为8
        age = 30;                    // 数字的长度为4
        rdf.writeBytes(name);        // 将姓名写入文件之中
        rdf.writeInt(age);            // 将年龄写入文件之中
        name = "lisi    ";            // 字符串长度为8
        age = 31;                    // 数字的长度为4
        rdf.writeBytes(name);        // 将姓名写入文件之中
        rdf.writeInt(age);            // 将年龄写入文件之中
        name = "wangwu  ";            // 字符串长度为8
        age = 32;                    // 数字的长度为4
        rdf.writeBytes(name);        // 将姓名写入文件之中
        rdf.writeInt(age);            // 将年龄写入文件之中
        rdf.close();                // 关闭
    }
}
