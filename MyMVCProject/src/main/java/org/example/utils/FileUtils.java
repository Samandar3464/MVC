package org.example.utils;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;

import java.io.*;

public class FileUtils {
    private final static String baseUrl = "D:\\Java programmalar\\KODLAR\\MVC\\bew\\MyMVCProject\\web\\WEB-INF\\template\\images\\";


    public static String savePhoto(HttpServletRequest request) {

        String photo = (request.getParameter("photo_url"));
        try {
            ServletInputStream inputStream = request.getInputStream();
            FileOutputStream outputStream = new FileOutputStream(baseUrl + photo);
            outputStream.write(inputStream.readAllBytes());
            return photo;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}