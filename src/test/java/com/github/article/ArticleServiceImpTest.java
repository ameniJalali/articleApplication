package com.github.article;

import com.github.article.entity.Article;
import com.github.article.exception.ArticleNotFoundException;
import com.github.article.repository.ArticleRepository;
import com.github.article.services.ArticleService;
import com.github.article.services.ArticleServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImpTest {

    @Mock
    private ArticleRepository articleRepository;

    @InjectMocks
    private ArticleServiceImpl articleService;
    private Article article;

    @Before
    public void setup() throws Exception {
        articleService = new ArticleServiceImpl(articleRepository);
        article = new Article();
        article.setArticleId(1L);
        article.setCategory("categ5");
        article.setTitle("title1");
    }

    @Test
    public void shouldReturnAllArticles() {
        //given
        List<Article> list = new ArrayList<>();
        list.add(article);
        when(articleRepository.findAll()).thenReturn(list);
        //when
        List<Article> articleList = articleService.getAllArticles();

        //then
        assertThat(articleList).containsExactly(article);
    }

    @Test
    public void getArticleDetails_returnArticleInfo() {
        //given
        given(articleRepository.findArticleByTitle("titlkk"))
                .willReturn(new Article(1L, "titlkk", "categ1"));
        //when
        Article article = articleService.getArticleDetails("titlkk");
        //then
        assertThat(article.getTitle()).isEqualTo("titlkk");
        assertThat(article.getCategory()).isEqualTo("categ1");

    }

    @Test(expected = ArticleNotFoundException.class)
    public void getArticleDetails_whenArticleNotFound() throws Exception {
        given(articleRepository.findArticleByTitle("titlkk")).willReturn(null);
        articleService.getArticleDetails("titlkk");
    }


}
