package exam0503.network;

import java.io.*;
import java.net.Socket;
import java.sql.ResultSet;

/**
 * Created by dell on 2017/5/3.
 */
public class Worker implements Runnable {
    private Socket client;

    public void setClient(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            String msgClient = null;
            while (true) {
                if (client.isClosed())
                    break;
                msgClient = dis.readUTF();
                System.out.println("Message from Client: " + msgClient);
                String replyMsg = replyMsg(msgClient);
                dos.writeUTF("Query result is [" + replyMsg+"]");
                dos.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    /*查询数据库，回复客户端的消息字符串*/
    public String replyMsg(String clientMsg) {
        MySqlConnector dbhelper = new MySqlConnector();
        StringBuffer strSQL = new StringBuffer();
        strSQL.append("select * from SYS_INFO ");
        strSQL.append("where Sys_no = '");
        strSQL.append(clientMsg);
        strSQL.append("'");

        StringBuffer tmp = new StringBuffer();
        try {
            ResultSet result = dbhelper.doQuery(strSQL.toString());
            while (result.next()) {
                tmp.append(result.getString("Sys_no")).append(",");
                tmp.append(result.getString("Sys_name")).append(",");
                tmp.append(result.getDate("Sys_date")).append(",");
                tmp.append(result.getString("Sys_status")).append(",");
                tmp.append(result.getDate("Next_work_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tmp.toString();
    }
}
