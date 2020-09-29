package com.github.article.services;

import com.github.article.entity.Article;
import com.github.article.exception.ArticleNotFoundException;
import com.github.article.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {


    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> getAllArticles() {
        List<Article> list = new ArrayList<>();
        articleRepository.findAll().forEach(e -> list.add(e));
        return list;
    }

    @Override
    public Article getArticleDetails(String title) {
        Article article = articleRepository.findArticleByTitle(title);
        if (article == null) {
            throw new ArticleNotFoundException();
        }
        return article;
    }

}
