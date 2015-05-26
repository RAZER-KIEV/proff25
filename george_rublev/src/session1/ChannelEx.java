package session1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by george on 18.05.15.
 */
public class ChannelEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt");
        SeekableByteChannel channel = Files.newByteChannel(path);
        ByteBuffer buffer = ByteBuffer.allocate(1);

//        channel.position(3);
//        channel.read(buffer);

        int readed;
        while ((readed = channel.read(buffer))>0) {
            String line = new String(buffer.array());
            System.out.println(line);
            buffer.clear();
        }
    }
}
