package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {

        //向服务端发送消息
        InetAddress address =  InetAddress.getByName("localhost");
        int port = 9000;
        System.out.println("客户端已经发送消息，等待服务器响应。。。");
        byte[] send_info = "我是客户端，用户名：hui，密码：123456".getBytes("UTF-8");
        DatagramSocket datagramSocket = new DatagramSocket();
        DatagramPacket sendPacket = new DatagramPacket(send_info,send_info.length,address,port);
        datagramSocket.send(sendPacket);

        //接收服务端的返回的消息。
        byte[] data = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(data,0,data.length);
        datagramSocket.receive(receivePacket);
        String info = new String(data,0,receivePacket.getLength());
        System.out.println("我是客户端，服务器响应："+info);
    }
}
