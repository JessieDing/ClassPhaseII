package d0329;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2017/3/29.
 */
public class RandomAccessFileDemo1 {
    public static void main(String args[]) throws Exception {
        //����������ʹ��throws�׳��쳣��JVM������ʡ�˺ܶ��쳣�������
        File f = new File("e:" + File.separator + "test.txt");    // ָ��Ҫ�������ļ�
        RandomAccessFile rdf = null;        // ����RandomAccessFile��Ķ���
        rdf = new RandomAccessFile(f, "rw");// ��дģʽ������ļ������ڣ����Զ�����
        String name = null;
        int age = 0;
        name = "zhangsan";            // �ַ�������Ϊ8
        age = 30;                    // ���ֵĳ���Ϊ4
        rdf.writeBytes(name);        // ������д���ļ�֮��
        rdf.writeInt(age);            // ������д���ļ�֮��
        name = "lisi    ";            // �ַ�������Ϊ8
        age = 31;                    // ���ֵĳ���Ϊ4
        rdf.writeBytes(name);        // ������д���ļ�֮��
        rdf.writeInt(age);            // ������д���ļ�֮��
        name = "wangwu  ";            // �ַ�������Ϊ8
        age = 32;                    // ���ֵĳ���Ϊ4
        rdf.writeBytes(name);        // ������д���ļ�֮��
        rdf.writeInt(age);            // ������д���ļ�֮��
        rdf.close();                // �ر�
    }
}
