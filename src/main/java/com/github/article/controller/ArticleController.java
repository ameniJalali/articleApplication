package com.github.article.controller;

import com.github.article.entity.Article;
import com.github.article.exception.ArticleNotFoundException;
import com.github.article.services.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/articles")
public class ArticleController {


    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();

    }

    @GetMapping("/{title}")
    public Article findArticleByTitle(@PathVariable("title") String title) {
        return articleService.getArticleDetails(title);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void articleNotFoundHandler(ArticleNotFoundException ex ){}

}
