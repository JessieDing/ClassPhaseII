import d0327.MyString;

import java.io.File;


public class TmpTest {

    public static void main(String[] args) {
       /*
        //�����ļ�
        File file = new File("c:" + File.separator + "test.txt");

        if (file.exists()) {
            System.out.println("�Ƿ����ļ���" + file.isFile());
            System.out.println("�Ƿ���Ŀ¼��" + file.isDirectory());
            System.out.println("�ļ����ȣ�" + file.length());
        } else {
            try {
                file.createNewFile();
                System.out.println("�ļ������ɹ�");
            } catch (Exception e) {

            }
        }
        */

        /*
        //����Ŀ¼
        File dir = new File("e:" + File.separator + "JavaDemo");
        if (!dir.exists()) {
            try {
                dir.mkdir();
                System.out.println("����Ŀ¼�ɹ�");
            } catch (Exception e) {
                System.out.println("����Ŀ¼ʧ��");
            }
        }
        */

        /*
        //ɾ��Ŀ¼
        try {
            dir.delete();
            System.out.println("ɾ��Ŀ¼�ɹ�");
        } catch (Exception e) {
            System.out.println("ɾ��Ŀ¼ʧ��");
        }
        */

        /*
        //����Ŀ¼
        File direc = new File("e:" + File.separator + "Book");
        if (direc.exists() && direc.isDirectory()) {
            File[] files = direc.listFiles();
            for (File file : files) {
                System.out.println(file.toString());
            }
        }
        */
        File direc = new File("e:" + File.separator + "Book");
        listOut(direc);

    }

    public static void listOut(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    listOut(files[i]);
                }
            }
        } else {
            System.out.println(file.toString());
        }
    }

}