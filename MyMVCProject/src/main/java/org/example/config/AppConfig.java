package org.example.config;

import org.example.dao.NewsDao;
import org.example.dao.UserDao;
import org.example.model.News;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@org.springframework.context.annotation.Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    @Bean
    SessionFactory sessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    @Bean
    UserDao userDao() {
        return new UserDao(sessionFactory());
     }
    @Bean
    NewsDao newsDao(){
        return  new NewsDao(sessionFactory());
    }

}
