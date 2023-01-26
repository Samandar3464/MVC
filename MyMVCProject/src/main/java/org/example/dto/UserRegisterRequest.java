package org.example.dto;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.example.utils.FileUtils;

@Data
public class UserRegisterRequest {
    private String name;
    private String username;
    private String phoneNumber;
    private String password;
    private String photo_url;

    public UserRegisterRequest(HttpServletRequest request) {
        this.name = request.getParameter("name");
        this.username = request.getParameter("username");;
        this.phoneNumber = request.getParameter("phoneNumber");;
        this.password = request.getParameter("password");;
        this.photo_url = request.getParameter(FileUtils.savePhoto(request));;
    }
}
