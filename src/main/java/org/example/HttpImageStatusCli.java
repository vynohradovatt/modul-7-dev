package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() throws IOException {

        System.out.println("Please enter HTTP status code");
        Scanner scanner = new Scanner(System.in);
        int code = scanner.nextInt();

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        downloader.downloadStatusImage(code);

    }

    public static void main(String[] args) throws IOException {
        new HttpImageStatusCli().askStatus();
    }
}
