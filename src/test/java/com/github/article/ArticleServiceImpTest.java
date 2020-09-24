package com.github.article;

import com.github.article.entity.Article;
import com.github.article.repository.ArticleRepository;
import com.github.article.services.ArticleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceImpTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleService articleService;
    private Article article;

    @Before
    public void setup(){
        articleRepository = mock(ArticleRepository.class);
        //articleService = new ArticleServiceImpl(articleRepository);
        articleService = Mockito.mock(ArticleService.class);
        article= new Article();
        article.setArticleId(1L);
        article.setCategory("categ5");
        article.setTitle("title1");
    }

    @Test
    public void shouldReturnAllArticles(){
        //when
        List<Article> list = new ArrayList<>();
        list.add(article);
        //given
        when(articleRepository.findAll()).thenReturn(list);
        //then
        assertThat(list.size()).isNotNull();
        assertThat(list.size()).isEqualTo(1);
    }
}
