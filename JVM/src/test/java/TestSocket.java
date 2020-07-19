import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author Chaos_Coke
 * @create 2020-07-19 14:05:38
 */
public class TestSocket {
    @Test
    public void test222() throws Exception {
        InetAddress inet01 = InetAddress.getLocalHost();
        System.out.println(inet01);
        InetAddress inet02 = InetAddress.getByName("baidu.com");
        System.out.println(inet02);
        String hostName = inet01.getHostName();
        System.out.println(hostName);
        String hostAddress=inet01.getHostAddress();
        System.out.println(hostName);
        System.out.println(hostAddress);
    }

    @Test
    public void test() throws IOException {
        String msg="约吗？";
        byte[] buf = msg.getBytes();
        DatagramPacket dp=new DatagramPacket(buf, buf.length,InetAddress.getLocalHost(),6666);
        DatagramSocket ds=new DatagramSocket(8888);
        ds.send(dp);
        ds.close();
    }

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(6666);
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf,buf.length);
        ds.receive(dp);
        int len = dp.getLength();
        System.out.println("len = " + len);
        System.out.println(new String(buf,0,len));
        String sendIp = dp.getAddress().getHostAddress();
        int port = dp.getPort();
        System.out.println(sendIp);
        System.out.println(port);
        ds.close();
    }
}
