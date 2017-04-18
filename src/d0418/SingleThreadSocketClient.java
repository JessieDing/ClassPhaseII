package d0418;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by Administrator on 2017/4/18.
 */
public class SingleThreadSocketClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",9999);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            Thread.sleep(1000);
//            dos.writeUTF("abcd");
            dos.writeUTF("jklm");
            dos.flush();

//            Socket socket = new Socket("192.168.10.132", 8088);
//            InetAddress inetAddress = socket.getInetAddress();
//            System.out.println("主机地址：" + inetAddress.getHostAddress());
//            System.out.println("本地地址：" + inetAddress.getLocalHost());
//            System.out.println("本地端口：" + socket.getLocalPort());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
