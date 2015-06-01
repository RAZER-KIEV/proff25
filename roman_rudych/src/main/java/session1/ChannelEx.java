package session1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Роман on 18.05.2015.
 */
public class ChannelEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt"); // Creates descriptor (file's path)
//        SeekableByteChannel channel = null;
        try (SeekableByteChannel channel = Files.newByteChannel(path)) {

           // channel = Files.newByteChannel(path); // creates channel
            ByteBuffer buffer = ByteBuffer.allocate(30); // creates buffer

            int readed;

//            while ((readed = channel.read(buffer)) > 0) {
//                String line = new String(buffer.array(), 0, readed);
//
//                System.out.print(line);
//                buffer.clear();
//            }
            readed = channel.read(buffer); // reads bytes from channel into buffer
            String line = new String(buffer.array(), 0, readed);

            System.out.print(line);
        }
    }
}
