package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        //接收客户端的消息。
        //创建服务器端的DatagramSocket，指定端口
        DatagramSocket datagramSocket = new DatagramSocket(9000);
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data,0,data.length);
        System.out.println("服务器已经启动，等待客户端发送数据");
        datagramSocket.receive(packet);
        String info = new String(data,0,packet.getLength());
        System.out.println("我是服务器，客户端说："+info);

        //向客户端返回消息
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        byte[] send_back = "欢迎您".getBytes("UTF-8");
        DatagramPacket backpacket = new DatagramPacket(send_back,send_back.length,address,port);
        datagramSocket.send(backpacket);
        datagramSocket.close();
    }
}
