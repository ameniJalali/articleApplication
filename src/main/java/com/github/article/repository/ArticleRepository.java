package com.github.article.repository;

import com.github.article.entity.Article;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends CrudRepository<Article, String>, JpaSpecificationExecutor<Article> {

    Article getByArticleId(Long articleId);

    Article  findArticleByTitle ( String title);
}
