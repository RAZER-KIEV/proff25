package CommandWork;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Sveta on 8/18/2015.
 */
public class FileFindService {

    public FileFindService() {
    }

    public String findFile(String name) throws FileNotFoundException {
        Path path = Paths.get("d:\\", name);

        if (Files.exists(path)) {
            return path.toString();

        } else {
            return "404";
//            throw new FileNotFoundException("Could not find a file");
        }
    }

    public File getFile (String path){
        return null;
    }
}
