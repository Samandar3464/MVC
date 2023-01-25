package org.example.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class UserDao {
    private final SessionFactory sessionFactory;


    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
