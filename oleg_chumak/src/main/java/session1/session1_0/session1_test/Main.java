package session1.session1_0.session1_test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by oleg on 18.05.15.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt");
        try(SeekableByteChannel channel = Files.newByteChannel(path)){
            ByteBuffer buffer = ByteBuffer.allocate(40);
            int readed;
            while((readed = channel.read(buffer)) > 0) {
                String str = new String(buffer.array(), 0, readed);
                System.out.println(str);
                buffer.clear();
            }
        }
    }
}