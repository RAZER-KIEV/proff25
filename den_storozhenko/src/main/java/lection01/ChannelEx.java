package lection01;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by storo_000 on 18.05.2015.
 */
public class ChannelEx {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("text.txt");
        //Files.size(path);//размер файла
        try (SeekableByteChannel channel = Files.newByteChannel(path)){
            ByteBuffer byteBuffer = ByteBuffer.allocate(30);// wrap


            //channel.position(2);//смещение пощиции
            //channel.position(channel.position()+1);//next

            //данные с каналла в буффер
            int readed;//кол-во считанных байт
            while ((readed = channel.read(byteBuffer)) > 0) {

                String line = new String(byteBuffer.array(), 0, readed);

                System.out.print(line);
                byteBuffer.clear();
                //byteBuffer.position(0);
            }
        }
    }
}

//считывание с файла


