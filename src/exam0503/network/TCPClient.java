package exam0503.network;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by dell on 2017/5/3.
 */
public class TCPClient {

    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 9999); //连接服务器
        System.out.println("Connected!");

        DataOutputStream dataout = new DataOutputStream(client.getOutputStream());
        DataInputStream dis = new DataInputStream(client.getInputStream());

        Thread.sleep(500);

        Scanner scan = new Scanner(System.in);
        while (true) {
            /* 输入HVPS或BEPS进行查询 */
            System.out.println("Enter query code(HVPS or BEPS or exit):");
            String query = scan.nextLine();
            if (query.equals("exit")) {
                break;
            } else {
                dataout.writeUTF(query);
                dataout.flush();
                System.out.println("Successfully send message to server.");
                System.out.println("Reply from server: " + dis.readUTF());
            }
        }
        client.close();
    }


}
