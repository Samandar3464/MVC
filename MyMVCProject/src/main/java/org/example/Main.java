package org.example;

import org.example.model.News;
import org.example.model.NewsBody;
import org.example.model.NewsTypeEnum;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import static org.example.model.NewsTypeEnum.UZB_NEWS;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(News.class)
                .addAnnotatedClass(NewsBody.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();


        Session session = sessionFactory.openSession();
        session.beginTransaction();
        NewsBody body = new NewsBody(1, "asdfghsdfghawsedrf");
        session.save(body);
        body.setId(1);
        News news = new News("Bugun", "Bugun", "Bugun", UZB_NEWS,body);
        session.save(news);

        session.getTransaction().commit();
        session.close();
        session.close();


    }
}