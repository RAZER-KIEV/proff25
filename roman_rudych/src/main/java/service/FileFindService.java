package service;





import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by Роман on 17.08.2015.
 */
public class FileFindService implements FileFindServiceInteface {

    class FileService {
        String pathF;
        FileSystem fileSystem;
        String searchedFile;
        int id;

        public void setSerchedFile(String fName) {
            searchedFile = fName;
        }

        public String findPath() throws IOException {
            id = 0;

            fileSystem = FileSystems.getDefault();
            Files.walkFileTree(fileSystem.getPath("\\Users\\RAZER\\workspace"),
                    new SimpleFileVisitor<java.nio.file.Path>() {
                        @Override
                        public FileVisitResult visitFile(java.nio.file.Path path, BasicFileAttributes attrs) {
                            String tmp = String.valueOf(path.getFileName());
                            if (tmp.equals(searchedFile)) {
                                System.out.println(" path = " + path);
                                Path resalt = path;
                                pathF += resalt;
                            }
                            return FileVisitResult.CONTINUE;
                        }
                    });
            return pathF;
        }
    }
    @Override
    public String findFile(String path){
        String result;

        FileService fileService = new FileService();
        fileService.setSerchedFile(path);
        try {
            result = fileService.findPath();
        }catch (IOException io){
            return "404";
        }

        return result;
    }
}
