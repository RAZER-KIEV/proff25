package session01;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Jeckgehor on 18.05.2015.
 */
public class ChannelEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt");
        try (SeekableByteChannel channel = Files.newByteChannel(path)) {
            ByteBuffer buffer = ByteBuffer.allocate(200);
            // channel.position(2);
            int readed;
            while ((readed = channel.read(buffer)) > 0) {
                String line = new String(buffer.array(), 0, readed);
                System.out.println(line);
                buffer.clear();
            }
        }
    }
}