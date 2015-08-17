package responseMaker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class ResponseMaker {
    private String request;

    /**
     *
     * @param request "404"||"400"||fullPathToFile
     */
    public ResponseMaker(String request) {
        this.request = request;
    }

    public String send() throws IOException {
        return makeResponse(request);
    }

    private String makeResponse(String request) throws IOException {
        switch (request) {
            case "400":
                return buildBadRequest();
            case "404":
                return buildFileNotFound();
            default:
                return buildFileContent();
        }
    }

    private String buildBadRequest(){
        return "HTTP/1.1 400 Bad request\n\r";
    }

    private String buildFileNotFound(){
        return "HTTP/1.1 404 File not found\n\r";
    }

    private String buildFileContent() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("HTTP/1.1 200 OK\n\rServer: nginx/1.2.1\n\rDate: ").append(new Date()).append("\n\r");
        String expansion= request.substring(request.indexOf('.')+1);
        switch (expansion){
            case "html":{
                result.append("Content-Type: text/html\n\r");
                String content = new String(Files.readAllBytes(Paths.get(request)));
                result.append("Content-Length: ").append(content.length()).append("\n\r\n\r");
                result.append(content);
                return result.toString();
            }
            case "htm":{
                result.append("Content-Type: text/html\r\n");
                String content = new String(Files.readAllBytes(Paths.get(request)));
                result.append("Content-Length: ").append(content.length()).append("\n\r\n\r");
                result.append(content);
                return result.toString();
            }
            case "jpeg":{
                result.append("Content-Type: image/jpeg\r\n");


                return result.toString();
            }
            case "gif":{
                result.append("Content-Type: image/gif\r\n");
                File file = new File(request);
                FileInputStream imageInFile = new FileInputStream(file);
                byte imageData[] = new byte[(int) file.length()];
                imageInFile.read(imageData);

                return result.toString();
            }
            case "bmp":{
                result.append("Content-Type: image/x-xbitmap\r\n");


                return result.toString();
            }
            default:{
                result.append("Content-Type: text/plain\r\n");


                return result.toString();
            }
        }
    }
}