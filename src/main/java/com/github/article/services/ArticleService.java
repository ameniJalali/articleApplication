package com.github.article.services;

import com.github.article.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {

    List<Article> getAllArticles();

    Optional<Article> getArticleById(long articleId);

}