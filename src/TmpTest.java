import d0327.MyString;

import java.io.File;


public class TmpTest {

    public static void main(String[] args) {
       /*
        //创建文件
        File file = new File("c:" + File.separator + "test.txt");

        if (file.exists()) {
            System.out.println("是否是文件：" + file.isFile());
            System.out.println("是否是目录：" + file.isDirectory());
            System.out.println("文件长度：" + file.length());
        } else {
            try {
                file.createNewFile();
                System.out.println("文件创建成功");
            } catch (Exception e) {

            }
        }
        */

        /*
        //创建目录
        File dir = new File("e:" + File.separator + "JavaDemo");
        if (!dir.exists()) {
            try {
                dir.mkdir();
                System.out.println("创建目录成功");
            } catch (Exception e) {
                System.out.println("创建目录失败");
            }
        }
        */

        /*
        //删除目录
        try {
            dir.delete();
            System.out.println("删除目录成功");
        } catch (Exception e) {
            System.out.println("删除目录失败");
        }
        */

        /*
        //遍历目录
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