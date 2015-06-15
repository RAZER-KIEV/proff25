package homeTasks.week3;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by HP on 05.06.2015.
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        if (args.length>0) {
            String host = args[0];
            InetAddress[] addresses = InetAddress.getAllByName(host);
            for (InetAddress a : addresses) {
                System.out.println(a);
            }
        }
            else {
                InetAddress localHostAddress= InetAddress.getLocalHost();
                System.out.println(localHostAddress);
            }
        }
    }

