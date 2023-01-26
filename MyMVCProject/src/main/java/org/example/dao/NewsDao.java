package org.example.dao;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.model.News;
import org.example.model.NewsBody;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository

public class NewsDao {
    private  SessionFactory sessionFactory;

    public NewsDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean addNews(HttpServletRequest request){
        sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(News.class)
                .addAnnotatedClass(NewsBody.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        News news = new News(request);
        NewsBody newsBody = new NewsBody(request);
        session.save(newsBody);

        news.setNewsBody(newsBody);
        session.save(news);

        session.getTransaction().commit();
        session.close();
        return true;


    }

    public List<News> getList() {
        List<News> newsList = null;
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        newsList=session.createQuery("from News").getResultList();
        session.getTransaction().commit();
        session.close();
        return newsList;
    }

    public boolean delete(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        News news =session.get(News.class ,id);
        if (news!=null){
            session.delete(news);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().commit();
        session.close();
        return false;
    }
}
