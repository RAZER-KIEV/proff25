package session1;

import java.io.File;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Віктор on 5/18/2015.
 */
public class Chanal {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get("text.txt");
        SeekableByteChannel channel = Files.newByteChannel(path);
        ByteBuffer buffer = ByteBuffer.allocate(60);
        int readed;
        while ((readed = channel.read(buffer)) > 0) {
            String line = new String(buffer.array(), 0, readed);

            System.out.print(line);
            buffer.clear();
        }


    }
}
