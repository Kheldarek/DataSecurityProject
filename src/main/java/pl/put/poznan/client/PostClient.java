package pl.put.poznan.client;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PostClient {

    // http://localhost:8080/RESTfulExample/json/product/post

    public static void main(String[] args) {
        String stop;
        do {
          receiveMessage();


          System.out.println("Wanna send another request?(Y/N)\n");
          Scanner scanner = new Scanner(System.in);
          stop = scanner.next().trim();
            stop.trim();

      }while (!stop.equals("N")&&!stop.equals("n"));
        System.out.println("Bye bye!\n");
    }

    static void receiveMessage()
    {
        try {

            URL url = new URL("http://localhost:8080");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }


}