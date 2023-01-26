package org.example.utils;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;

import java.io.*;

public class FileUtils {
    private final static String baseUrl = "\\home\\shodiyorbek\\Desktop\\MVC\\MyMVCProject\\web\\WEB-INF\\img\\";


    public static String savePhoto(HttpServletRequest request) {

        String photo = (request.getParameter("photo_url"));
        try {


            ServletInputStream inputStream = request.getInputStream();
            String url = baseUrl+photo;
            File file =new File(baseUrl);
            FileOutputStream outputStream = new FileOutputStream(file);
            boolean exists = file.exists();
            System.out.println(exists);
            outputStream.write(inputStream.readAllBytes());
            outputStream.close();
            return photo;
        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }
}