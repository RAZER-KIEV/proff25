package session01;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by lukashevich.e on 19.05.2015.
 */
public class ChannelExHome {
    public static void main (String[] args) throws IOException {
        Path filepath = Paths.get("perechen_zadach.txt");
        System.out.println(Files.size(filepath));
        System.out.println(filepath.toAbsolutePath());
        try (SeekableByteChannel fileChannel = Files.newByteChannel(filepath)) {
            ByteBuffer mBuffer = ByteBuffer.allocate(200);
            System.out.println(fileChannel.read(mBuffer));
            int count;
            do {
                count = fileChannel.read(mBuffer);
                mBuffer.rewind();
                StringBuilder str = new StringBuilder("");
                for (int i = 0; i < count; i++) {
                    str.append((char)mBuffer.get());
                }
                System.out.print(str.toString());
            }
            while (count != -1);
        }
    }
}