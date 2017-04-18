package d0418;

import java.net.Socket;

/**
 * Created by Administrator on 2017/4/18.
 */
public class TCPServer {
    public static void main(String[] args) {

    }
}

class Worker implements Runnable{
    Socket client;

    public void setClient(Socket client) {
        this.client = client;
    }

    public void run(){
        try{

        }
    }
}
