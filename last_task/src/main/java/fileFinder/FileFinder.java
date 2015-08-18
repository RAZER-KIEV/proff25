package fileFinder;

import java.io.File;

public class FileFinder {
    private String pathToSearch;

    public FileFinder() {
    }

    public String getPathToSearch() {
        return pathToSearch;
    }

    public void setPathToSearch(String pathToSearch) {
        this.pathToSearch = pathToSearch;
    }

    public String findFile() {
        String[] folders = pathToSearch.split("/");
        File file = new File(pathToSearch.substring(0, pathToSearch.lastIndexOf('/') + 1));
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.getName().equals(folders[folders.length - 1])) {
                return pathToSearch;
            }
        }
        return "404";
    }
}