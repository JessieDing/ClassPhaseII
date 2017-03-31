package d0331;

import java.io.*;

/**
 * Created by Administrator on 2017/3/31.
 */
public class IOTest {
    public static void main(String[] args) {
        try {
//            testFOS();
//            testFIS();
//            testCopyFile();
//            testBOS();
//            testBIS();
            testOOS();
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
        bos.flush();//显示写入  ??作用
        bos.close();
    }

    public static void testBIS() throws Exception {
        //创建缓冲字节输入流
        FileInputStream fis = new FileInputStream("e:" + File.separator + "bisDemo.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int tmp = -1;
        //缓冲读入，实际上并非是一个字节一个字节读入的
        while ((tmp = bis.read()) != -1) {
            System.out.print((char) tmp);
        }
        bis.close();
    }


    public static void testOOS() throws Exception {
        //对象序列化示例
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "emp.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Emp emp = new Emp("张三", "0001", "男", 29);
        oos.writeObject(emp);
        System.out.println("序列化完毕");
        oos.close();
        fos.close();

        //对象反序列化
        FileInputStream fis = new FileInputStream("e:" + File.separator + "emp.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Emp emp1 = (Emp) ois.readObject();
        System.out.println(emp1.toString());
        System.out.println("反序列化完毕");
        ois.close();
        fis.close();
    }
}

class Emp implements Serializable {//该类实现Serializable接口，可进行序列化
    private String name;
    private String id;
    private String gender;
    private int age;
    private static final long serialVersionUID = 1L;

    public Emp() {
    }

    public Emp(String name, String no, String gender, int age) {
        this.name = name;
        this.id = no;
        this.gender = gender;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
}
