package homework0419;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dell on 2017/4/19.
 */
public class TCPClient {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 9999); //连接服务器
        System.out.println("Connected!");

        DataOutputStream dataout = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());

        Thread.sleep(500);

		/* 循环输入 */
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("enter message:");
            String line = s.nextLine();
            if (line.equals("exit")) {
                break;
            } else {
                dataout.writeUTF(line);
                dataout.flush();
                System.out.println("Successfully send message to server.");
                System.out.println("Reply from server: " + dis.readUTF());
            }
        }
        s.close();
        client.close();
    }
}
