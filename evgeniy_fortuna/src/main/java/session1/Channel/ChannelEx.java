package session1.Channel;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by jul on 27.06.2015.
 */
public class ChannelEx {
    public static void main(String[] args)  throws IOException{
        Path path = Paths.get("text.txt");  // дескриптор файла
        SeekableByteChannel channel = null;
        try {
            channel = Files.newByteChannel(path);  // канал, который подключится к этому файлу
            // буфер создаем отдельно от канала, в который канал будет помещать нам данные во время чтения или записи

            ByteBuffer buffer = ByteBuffer.allocate(40);  // буфер с указанным размером
//        channel.position(2);  // читаем с этой позиции

            int readed;
            // размер массива не может позволить прочитать всё. лучше читать через while. Читаем, пока файл не закончится
            while ((readed = channel.read(buffer)) > 0){

                String line = new String (buffer.array(), 0, readed); // создаем строку байт от первого символа до того,который был считан последним
                System.out.print(line);
                buffer.clear();
            }
        } finally {
            if (channel != null){
                channel.close();
            }
        }

        // считываем данные из файла через канал в буфер
//        int readed = channel.read(buffer);  // сохраняем количество реально считанных байт

        // извлекаем данные из нашего буфера. В нашем случае данные - в виде массива байт.
        // String умеет создавать строки на основании массива байт
    }
}
