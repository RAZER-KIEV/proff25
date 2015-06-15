package hw5.finder;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;

/**
 * Created by Sveta on 6/13/2015.
 */
public class FileService {

    public Path getPath(String fileName, String extension) {
        Path path = new Path();
        try{
            File temp = File.createTempFile(fileName, extension);
            path.setPath(temp.getAbsolutePath());

        }catch(IOException e){
            e.printStackTrace();
        }
        return path;
    }

    public Date getDate(String path) throws URISyntaxException, IOException {

        java.nio.file.Path source = Paths.get(this.getClass().getClassLoader().getResource(path).toURI());
        BasicFileAttributes attr = Files.readAttributes(source, BasicFileAttributes.class);
        FileTime fileCreated = attr.creationTime();

        Date date = new Date(fileCreated.toMillis());

        return date;
    }

}
