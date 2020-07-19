import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author Chaos_Coke
 * @create 2020-07-19 14:35:27
 */
public class Client {
    public static void main(String[] args) throws Exception {
        String msg="约吗？";
        byte[] buf = msg.getBytes();
        DatagramPacket dp=new DatagramPacket(buf, buf.length, InetAddress.getLocalHost(),6666);
        DatagramSocket ds=new DatagramSocket(8888);
        ds.send(dp);
        ds.close();
    }
}
