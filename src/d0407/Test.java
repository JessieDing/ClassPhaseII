package d0407;

import java.io.*;

/**
 * Created by Administrator on 2017/4/7.
 */
public class Test {
    public static void main(String[] args) {
        try {
//            testWriterUTF8();
//            testReaderUTF8();
//            testPrinterWriter();
            testBufferedReader();
        } catch (Exception e) {
        }

    }

    public static void testWriterUTF8() throws Exception {
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "testWriter.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
        String str = "这是测试字符串。";
        osw.write(str);
        System.out.println("写入成功");
        osw.close();

    }

    public static void testReaderUTF8() throws Exception {
        FileInputStream fis = new FileInputStream("e:" + File.separator + "testWriter.txt");
        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
        int c = -1;
        while ((c = isr.read()) != -1) {
            System.out.print((char) c);
        }
        isr.close();
    }

    public static void testPrinterWriter() throws Exception {
        FileOutputStream fos = new FileOutputStream("e:" + File.separator + "testWriter.txt");
        PrintWriter printWriter = new PrintWriter(fos, true);//指定行刷新
        printWriter.write("第一行测试");
        printWriter.write("第二行测试");
        printWriter.println("第一行println测试");//等价于加换行符
        printWriter.println("第二行println测试");
        printWriter.close();
    }


    public static void testBufferedReader() throws Exception {
        FileInputStream fis = new FileInputStream("e:" + File.separator + "testWriter.txt");
        InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
        BufferedReader bufReader = new BufferedReader(isr);
        String str;
        while ((str = bufReader.readLine()) != null) {
            System.out.println(str);
        }
        bufReader.close();
    }

}
