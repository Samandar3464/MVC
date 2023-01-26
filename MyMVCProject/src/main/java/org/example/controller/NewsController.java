package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.dao.NewsDao;
import org.example.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
    private final NewsDao newsDao;
    public NewsController(NewsDao newsDao) {
        this.newsDao=newsDao;
    }

    @GetMapping(value = "/add" )
    public String addNews() {
        return "news/addNews";
    }

    @GetMapping("/save")
    public String saveNews(HttpServletRequest request) {
        newsDao.addNews(request);
        return "news/main";
    }
    @GetMapping("/show")
    public String showListNews(Model model) {
        List<News> newsList =newsDao.getList();
        model.addAttribute("news" ,newsList);
        return "news/main";
    }
    @PostMapping("/update")
    public String updateNews(HttpServletRequest request) {
        newsDao.addNews(request);
        return "main";
    }
    @GetMapping("/delete{id}")
    public String deleteNews(@PathVariable("id") int id) {
        id=2;
        newsDao.delete(id);
        return "main";
    }
}
