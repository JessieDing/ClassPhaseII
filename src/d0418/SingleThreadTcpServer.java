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
                Socket socket = server.accept();//���տͻ�����������I/O�ն�
                System.out.println("A client connect!");

                //�շ�����
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());//������
//                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());//�����

                /*
                * ����˴������ݵĶ�д������ʱ̫����
                * �޷����ؼ���accept
                * Ӧ�����ݶ�д�������ɹ����߳̽��д���
                * �ͷ����߳�
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
