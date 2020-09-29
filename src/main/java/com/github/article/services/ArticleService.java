package com.github.article.services;

import com.github.article.entity.Article;

import java.util.List;

public interface ArticleService {

    List<Article> getAllArticles();

    Article getArticleDetails(String title);
}