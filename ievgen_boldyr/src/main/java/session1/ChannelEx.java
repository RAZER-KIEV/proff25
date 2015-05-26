package session1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by nucleos on 18.05.15.
 */
public class ChannelEx {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text2.txt");
        SeekableByteChannel channel = Files.newByteChannel(path);
        ByteBuffer byteBuffer = ByteBuffer.allocate(30);

        int readed = channel.read(byteBuffer);
        String line = new String(byteBuffer.array(), 0, readed);

        System.out.println(line);
    }
}
