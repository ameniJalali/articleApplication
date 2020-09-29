package com.github.article.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="articles")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    private String title;

    private String category;

    public Article() {
    }
    public Article( String title, String category) {
        this.title = title;
        this.category = category;
    }

    public Article(Long articleId , String title, String category) {
        this.articleId=articleId;
        this.title = title;
        this.category = category;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}