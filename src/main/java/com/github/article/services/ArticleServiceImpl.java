package com.github.article.services;

import com.github.article.entity.Article;
import com.github.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        List<Article> list = new ArrayList<>();
        articleRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Optional<Article> getArticleById(Long articleId) {
        Article article = articleRepository.getByArticleId(articleId);
        return Optional.of(article);
    }

}
