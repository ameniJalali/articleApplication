package com.github.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class ArticleApplication {
    private static final Logger log = LoggerFactory.getLogger(ArticleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }

}
