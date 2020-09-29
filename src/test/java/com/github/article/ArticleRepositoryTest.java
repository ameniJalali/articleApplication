package com.github.article;

import com.github.article.entity.Article;
import com.github.article.repository.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void findByTitle_returnsArticle() throws Exception {
        Article savedArticle = testEntityManager.persistFlushFind(
                new Article("test5", "testtcat"));

        Article article = articleRepository.findArticleByTitle("test5");
        assertThat(article.getTitle()).isEqualTo(savedArticle.getTitle());
        assertThat(article.getCategory()).isEqualTo(savedArticle.getCategory());


    }
}
