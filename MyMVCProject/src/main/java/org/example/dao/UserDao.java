package org.example.dao;

import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.example.dto.UserLoginRequest;
import org.example.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;


import java.io.Serializable;


@Repository

public class UserDao {
    private final SessionFactory sessionFactory;


    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean add(User user) {
        SessionFactory sessionFactory = new Configuration()
                .configure()
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Object save = session.save(user);
        session.getTransaction().commit();
        session.close();
        if(save == null){
            return false;
        }
        return true;

    }

    public User login(final UserLoginRequest userLoginRequest) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String queryString = "FROM User WHERE phoneNumber=:phoneNumber and password=:password";
        Query query = session.createQuery(queryString);
        query.setParameter("phoneNumber",userLoginRequest.getPhoneNumber());
        query.setParameter("password",userLoginRequest.getPassword());
        User singleResult = (User) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return singleResult;
    }

}
