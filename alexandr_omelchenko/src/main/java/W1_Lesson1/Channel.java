package W1_Lesson1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Channel {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt");
        try
                (SeekableByteChannel channel = Files.newByteChannel(path)){
            ByteBuffer buffer = ByteBuffer.allocate(30);
           // channel.position(2);
            //channel.read(buffer);
            int readed;
            while ((readed = channel.read(buffer)) > 0) {
                //int readed = channel.read(buffer);
                String line = new String(buffer.array(), 0, readed);
                System.out.println(line);
                buffer.clear();
            }
        }
    }
}