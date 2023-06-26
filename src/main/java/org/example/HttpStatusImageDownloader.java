package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) throws IOException {

        String urlImage = new HttpStatusChecker().getStatusImage(code);

        try (InputStream is = new URL(urlImage).openStream()) {
            String path = "cats/" + code + ".img";

            if (!new File(path).exists()) {
            Files.copy(is, Paths.get(path));
            } else {
            System.out.println("File with code: " + code + " is already exist!");
        }

        } catch(IOException e) {
        throw new FileNotFoundException("There is not image for HTTP status " + code);

        }
    }

    public static void main(String[] args) throws IOException {

        new HttpStatusImageDownloader().downloadStatusImage(300);
    }
}
