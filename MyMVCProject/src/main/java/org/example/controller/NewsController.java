package org.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.dao.NewsDao;
import org.example.model.News;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/news")
public class NewsController {
    private final NewsDao newsDao;

    public NewsController(NewsDao newsDao) {
        this.newsDao = newsDao;
    }

    @GetMapping("/add")
    public String addNews() {
        return "news/addNews";
    }
    @GetMapping("/save")
    public String saveNews(HttpServletRequest request) {
        newsDao.addNews(request);
        return "redirect:show";
    }
    @GetMapping("")
    public String home(Model model){
        List<News> list = newsDao.getList();
        model.addAttribute("news",list);
        return "news/blog";
    }

    @GetMapping("info")
    public String info(Model model){
        List<News> list = newsDao.getList();
        model.addAttribute("news",list);
        return "redirect:show";
    }
    @GetMapping("/show")
    public String showListNews(Model model) {
        List<News> newsList = newsDao.getList();
        model.addAttribute("newsList", newsList);
        return "news/main";
    }

    @GetMapping("/update")
    public String updateNews(HttpServletRequest request) {
       newsDao.update(request);
        return "redirect:show";
    }

    @GetMapping(value = "/delete{id}")
    public String deleteNews(HttpServletRequest request) {
        String id = request.getParameter("id");
        if (id != null) {
            int id1 = Integer.parseInt(id);
            newsDao.delete(id1);
        }
        return "redirect:show";
    }
}
