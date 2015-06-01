package session1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Created by bosyi on 18.05.15.
 */
public class ChannelEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("ttt");
        try (SeekableByteChannel channel = Files.newByteChannel(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(40);
            int readed;
            //channel.position(2);
            while ((readed = channel.read(buffer)) > 0) {
                System.out.println(readed);
                String line = new String(buffer.array(), 0, readed);
                System.out.print(line);
                buffer.clear();
            }
        }

        /*
        System.out.println(buffer);
        System.out.println(line.length());
        System.out.println(Arrays.toString(line.getBytes()));
        */

    }
}
