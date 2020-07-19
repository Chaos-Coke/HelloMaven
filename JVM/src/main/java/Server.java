import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author Chaos_Coke
 * @create 2020-07-19 14:35:18
 */
public class Server {
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
