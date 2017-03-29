package d0329;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * Created by Administrator on 2017/3/29.
 */
public class RandomAccessDemo2 {
    // ���е��쳣ֱ���׳��������в��ٽ��д���
    public static void main(String args[]) throws Exception {
        File f = new File("e:" + File.separator + "test.txt");    // ָ��Ҫ�������ļ�
        RandomAccessFile rdf = null;        // ����RandomAccessFile��Ķ���
        rdf = new RandomAccessFile(f, "r");// ��ֻ���ķ�ʽ���ļ�
        String name = null;
        int age = 0;
        byte b[] = new byte[8];    // ����byte����
        // ��ȡ�ڶ����˵���Ϣ����ζ��Ҫ�ճ���һ���˵���Ϣ
        rdf.skipBytes(12);        // ������һ���˵���Ϣ
        for (int i = 0; i < b.length; i++) {
            b[i] = rdf.readByte();    // ��ȡһ���ֽ�
        }
        name = new String(b);    // ����ȡ������byte�����Ϊ�ַ��������������ŵ�string�����б��String�ַ�����
        age = rdf.readInt();    // ��ȡ���֡�������//readInt������ȡ�Ĵ�Сǡ����4���ֽڣ���ȡǰ��8���ַ�������ļ������֡�
        System.out.println("�ڶ����˵���Ϣ --> ������" + name + "�����䣺" + age);
        // ��ȡ��һ���˵���Ϣ
        rdf.seek(0);    // ָ��ص��ļ��Ŀ�ͷ
        for (int i = 0; i < b.length; i++) {
            b[i] = rdf.readByte();    // ��ȡһ���ֽ�
        }
        name = new String(b);    // ����ȡ������byte�����Ϊ�ַ���
        age = rdf.readInt();    // ��ȡ����
        System.out.println("��һ���˵���Ϣ --> ������" + name + "�����䣺" + age);
        rdf.skipBytes(12);    // �ճ��ڶ����˵���Ϣ
        for (int i = 0; i < b.length; i++) {
            b[i] = rdf.readByte();    // ��ȡһ���ֽ�
        }
        name = new String(b);    // ����ȡ������byte�����Ϊ�ַ���
        age = rdf.readInt();    // ��ȡ����
        System.out.println("�������˵���Ϣ --> ������" + name + "�����䣺" + age);
        rdf.close();                // �ر�
    }
}
