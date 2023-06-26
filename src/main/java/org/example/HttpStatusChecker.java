package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpStatusChecker {

    public String getStatusImage(int code) throws IOException {

        String urlImg = "https://http.cat/" + code + ".jpg";

        HttpURLConnection connection = (HttpURLConnection) new URL(urlImg).openConnection();

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_NOT_FOUND) {

            throw new FileNotFoundException("Image not found for status code: " + code);
        } else {

            return urlImg;
        }
    }

    public static void main(String[] args) throws Exception {

        String image = new HttpStatusChecker().getStatusImage(200);

        String imageNotFound = new HttpStatusChecker().getStatusImage(10000); // викидає помилку, сторінки не існує

        System.out.println(image);

        System.out.println(imageNotFound);
    }

}
