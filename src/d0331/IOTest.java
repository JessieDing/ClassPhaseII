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
        System.out.println("�������");
        fos.close();
        fis.close();
    }

    public static void testBOS() throws Exception {
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "fos.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write("BufferedOutputStream test message.".getBytes());
        bos.flush();//��ʾд��  ??����
        bos.close();
    }

    public static void testBIS() throws Exception {
        //���������ֽ�������
        FileInputStream fis = new FileInputStream("e:" + File.separator + "bisDemo.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        int tmp = -1;
        //������룬ʵ���ϲ�����һ���ֽ�һ���ֽڶ����
        while ((tmp = bis.read()) != -1) {
            System.out.print((char) tmp);
        }
        bis.close();
    }


    public static void testOOS() throws Exception {
        //�������л�ʾ��
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "emp.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Emp emp = new Emp("����", "0001", "��", 29);
        oos.writeObject(emp);
        System.out.println("���л����");
        oos.close();
        fos.close();

        //�������л�
        FileInputStream fis = new FileInputStream("e:" + File.separator + "emp.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Emp emp1 = (Emp) ois.readObject();
        System.out.println(emp1.toString());
        System.out.println("�����л����");
        ois.close();
        fis.close();
    }
}

class Emp implements Serializable {//����ʵ��Serializable�ӿڣ��ɽ������л�
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
