package com.example.newsPage.controller;

import com.example.newsPage.model.News;
import com.example.newsPage.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public String getNewsPage(Model model) {
        System.out.println("test");
        List<News> newsList = newsService.getAllNews();
        newsList.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
        model.addAttribute("newsList", newsList);
        return "Pages/news-page";
    }

    @GetMapping("/latestNews")
    public String getLatestNewsPage(Model model) {
        List<News> newsList = newsService.getTopNews();
        if (newsList.isEmpty()) {
            return "redirect:/news";
        }
        newsList.sort((n1, n2) -> n2.getDate().compareTo(n1.getDate()));
        model.addAttribute("newsList", newsList);
        return "Pages/news-page";
    }
}
