package exam0503.network;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dell on 2017/5/3.
 * 先运行DataBase创建数据表
 */
public class TCPServer {

    public static void main(String[] args) throws Exception {
       /* MySqlConnector connector = new MySqlConnector();
        prepDataBase(connector);*/

        short port = 9999;
        ServerSocket server = new ServerSocket(port);//绑定端口
        System.out.println("Server start, port binding:" + port);

        while (true) {
            Socket socket = server.accept(); // 接收客户端连接 网络I/O终端
            System.out.println("a client connect!" + socket);

            // 创建工作线程，进行收发数据
            Worker wk = new Worker();
            wk.setClient(socket);

            Thread tWork = new Thread(wk);
            System.out.println("Create new thread: " + tWork.getId());
            tWork.start();
        }
    }

 /*   private static void prepDataBase(MySqlConnector dbhelper) {
        String createTable = dbhelper.createTable();
        dbhelper.doUpdate(createTable);
        String insertSQL1 = "INSERT INTO sys_info VALUES('HVPS','High Value Payment',CURDATE(),'0000',DATE_SUB(CURDATE(),INTERVAL -1 DAY))";
        dbhelper.doUpdate(insertSQL1);
        String insertSQL2 = "INSERT INTO sys_info VALUES('BEPS','Bulk Electronic Payment',CURDATE(),'0000',DATE_SUB(CURDATE(),INTERVAL -1 DAY))";
        dbhelper.doUpdate(insertSQL2);
    }*/
}
