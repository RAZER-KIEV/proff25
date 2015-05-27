package session1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 22.04.15
 */
public class ChannelEx {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("text.txt");
        SeekableByteChannel channel = null;
        try {
            channel = Files.newByteChannel(file);
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int read;
            while ((read = channel.read(buffer)) > 0) {
                System.out.print(new String(buffer.array(), 0, read));
                buffer.clear();
            }
        } finally {
            if (channel != null) {
                channel.close();
            }
        }

        try (SeekableByteChannel channel1 = Files.newByteChannel(file)) {
            ByteBuffer buffer = ByteBuffer.allocate(20);
            int read;
            while ((read = channel1.read(buffer)) > 0) {
                System.out.print(new String(buffer.array(), 0, read));
                buffer.clear();
            }
        }

    }
}
