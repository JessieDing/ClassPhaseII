package homework0419;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by dell on 2017/4/21.
 */
public class TCPServer {
    public static void main(String[] args) throws Exception {
        short port = 9999;
        ServerSocket server = new ServerSocket(port); // 创建ServerSocket,并且绑定9999端口
        System.out.println("Server start, port binding:" + port);

        while (true) {
            Socket s = server.accept(); // 接收客户端连接 网络I/O终端!!!!!!!
            System.out.println("a client connect!" + s);

            // 创建工作线程，进行收发数据
            Worker wk = new Worker();
            wk.setClient(s);   //  !!!!!!

            Thread tWork = new Thread(wk);
            System.out.println("Create new thread: " + tWork.getId());
            tWork.start();
        }
    }


}

class Worker implements Runnable {
    Socket client;

    public void setClient(Socket client) {
        this.client = client;
    }

    public void run() {
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());
            // int len = 0;
//            char tmp = '\0';
//            StringBuffer sb = new StringBuffer("");
            while (true) {
                if (client.isClosed())
                    break;
                //tmp = dis.readChar();
                String strMsg = dis.readUTF();

                //XiaoTian Tech Co. Ltd,62234500000001,3000.00,Lisa,5223450000000
                System.out.println("strMsg:" + strMsg);
                String[] msgArr = strMsg.split(",");

                String payerName = msgArr[0]; // 接收从客户端发来的数据
                String payerAcct = msgArr[1];
                double payAmt = Double.parseDouble(msgArr[2]);
                String payeeName = msgArr[3];
                String payeeAcct = msgArr[4];

                Payment payment = new Payment(payerName, payerAcct, payAmt, payeeName, payeeAcct);//一笔支付
                payment.calcFee();//计算手续费

                writeXml("e:" + File.separator + "payments.xml", payment);

                dos.writeUTF("Your message[" + strMsg + "] is received."); // 向客户端回消息
                dos.flush();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getStackTrace();
        }
    }

    public static void writeXml(String filePath, Payment pay) throws Exception {
        Document doc = null;
        Element root = null;

        File xmlFile = new File(filePath);
        if (xmlFile.exists()) {//判断
            SAXReader reader = new SAXReader();
            try {
                doc = reader.read(xmlFile);
                root = doc.getRootElement();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            doc = DocumentHelper.createDocument();//创建文档对象
            root = doc.addElement("payments"); //添加根元素
        }

        Element payment = root.addElement("payment");//添加payment子元素
        Element payerName = payment.addElement("payerName");
        payerName.addText(pay.getPayerName());

        Element payerAcct = payment.addElement("payerAcct");
        payerAcct.addText(pay.getPayerAcct());

        Element payAmt = payment.addElement("payAmt");
        payAmt.addText(String.valueOf(pay.getPayAmt()));

        Element payeeName = payment.addElement("payeeName");
        payeeName.addText(pay.getPayeeName());

        Element payeeAcct = payment.addElement("payeeAcct");
        payeeAcct.addText(pay.getPayeeAcct());

        Element fee = payment.addElement("fee");
        fee.addText(String.valueOf(pay.getFee()));

        // 写出
        XMLWriter writer = new XMLWriter();
        FileOutputStream fos = new FileOutputStream(filePath);
        writer.setOutputStream(fos);
        writer.write(doc);
        System.out.println("Write successfully!");
        writer.close();
    }
}
