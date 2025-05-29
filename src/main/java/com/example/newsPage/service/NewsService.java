package com.example.newsPage.service;

import com.example.newsPage.model.News;
import com.example.newsPage.repository.NewsRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    @Value("${newsapi.key}")
    private String apiKey;
    private final RestTemplate restTemplate;
    private final NewsRepository newsRepository;

    public NewsService(RestTemplate restTemplate, NewsRepository newsRepository) {
        this.restTemplate = restTemplate;
        this.newsRepository = newsRepository;
    }

    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    public List<News> getTopNews() {
        try {
            String url = "https://api.thenewsapi.com/v1/news/top?api_token=" + apiKey + "&locale=us";

            String jsonResponse = restTemplate.getForObject(url, String.class);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            List<News> newsList = new ArrayList<>();
            JsonNode dataArray = rootNode.path("data"); // Adjust based on the JSON structure

            for (JsonNode newsNode : dataArray) {
                String title = newsNode.path("title").asText();
                String content = newsNode.path("description").asText();
                String link = newsNode.path("url").asText();
                String date = newsNode.path("published_at").asText().split("T")[0];;
                LocalDate formattedDate = LocalDate.parse(date);
                String imgUrl = newsNode.path("image_url").asText();
                News news = new News(title, content, link, formattedDate, imgUrl);
                newsList.add(news);
            }

            return newsList;
        } catch (Exception e) {
            // Log the error and return an empty list
            System.err.println("Error fetching news: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

