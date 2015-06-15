package homeTasks.week3;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by HP on 05.06.2015.
 */
public class SocketTest {
    public static void main(String[] args) throws IOException
    {
        try (Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13))
        {
            InputStream inStream = s.getInputStream();
            Scanner in = new Scanner (inStream);
            while(in.hasNextLine()){
                String line = in.nextLine();
                System.out.println(line);
            }
        }
    }
}
