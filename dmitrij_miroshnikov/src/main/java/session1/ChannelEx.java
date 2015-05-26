package session1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ChannelEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt");//путь к файлу
        SeekableByteChannel channel=null;
        try {
        //try (SeekableByteChannel channel=Files.newByteChannel(path)) {
            channel = Files.newByteChannel(path);
            ByteBuffer buffer = ByteBuffer.allocate(30);//размер буфера - 30 байт
        /*channel.position(4);//начальная позиция чтения
        int readed=channel.read(buffer);
        String line=new String(buffer.array(), 0, readed);
        System.out.println(line);*/

            int readed;
            while ((readed = channel.read(buffer)) > 0) {

                String line = new String(buffer.array(), 0, readed);
                System.out.print(line);
                buffer.clear();
            }
        } finally {
            channel.close();
        }
    }
}
