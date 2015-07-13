package session1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ivan on 18.05.15.
 */
public class ChannelEx {
    public static void main(String[] args) throws IOException{
//        Path path = Paths.get("text.txt");

//        SeekableByteChannel channel = null;
//        try(SeekableByteChannel channel = Files.newByteChannel(path)) {
//            channel = Files.newByteChannel(path);
//            ByteBuffer buffer = ByteBuffer.allocate(30);
//            channel.position(0);//  Задаем позицию, с которой читаем их буфера
//            int readed;
//            while ((readed = channel.read(buffer)) > 0) {
//                String line = new String(buffer.array(), 0, readed);
//
//                System.out.print(line);
//                buffer.clear();
//            }
//            channel.read(buffer); // Через канал данные из файла поступают в буфер
            //Получаем данные в качестве массива байт
//        String line = new String(buffer.array());
//        String line2 = new String(buffer.array(),2,readed);
//        System.out.println(line);
//        System.out.println(line2);
        }
//        finally {
//            if (channel != null){
//                channel.close();
//            }
//        }
    }

//}
