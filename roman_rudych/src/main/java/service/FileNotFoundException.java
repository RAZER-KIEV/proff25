package service;

import java.io.IOException;

/**
 * Created by Роман on 17.08.2015.
 */
public class FileNotFoundException extends IOException {

    public FileNotFoundException(String message) {
        super(message);
    }
}
