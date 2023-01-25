package org.example.dao;

import org.hibernate.SessionFactory;

public class NewsDao {
    private final SessionFactory sessionFactory;
    public NewsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
