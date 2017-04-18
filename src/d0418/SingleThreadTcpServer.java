package d0418;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/4/18.
 */
public class SingleThreadTcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9999);
            System.out.println("Server start ok.");
            while (true) {
                System.out.println("Server listening.");
                Socket socket = server.accept();//接收客户端连接网络I/O终端
                System.out.println("A client connect!");

                //收发数据
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());//输入流
//                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());//输出流

                /*
                * 如果此处对数据的读写操作耗时太长，
                * 无法返回继续accept
                * 应将数据读写操作交由工作线程进行处理
                * 释放主线程
                * */
                String c = inputStream.readUTF();
                System.out.println(c);

                inputStream.close();
//                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
