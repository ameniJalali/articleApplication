package com.github.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.article.controller.ArticleController;
import com.github.article.entity.Article;
import com.github.article.exception.ArticleNotFoundException;
import com.github.article.services.ArticleService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringRunner.class)
@WebMvcTest(controllers = ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    private List<Article> articleList;

    @Before
   public  void setUp() {
        this.articleList = new ArrayList<>();
        this.articleList.add(new Article(1L, "title1","categ1"));
        this.articleList.add(new Article(2L, "title2","categ2"));
        this.articleList.add(new Article(3L, "title3","categ3"));
    }

    @Test
    public void shouldFetchAllArticles() throws Exception {
        given(articleService.getAllArticles()).willReturn(this.articleList);

        this.mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnArticle() throws Exception {
        given(articleService.getArticleDetails(anyString())).willReturn(new Article(4L, "titlkk","categ1"));

        mockMvc.perform(get("/api/articles/titlkk"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("title").value("titlkk"))
                .andExpect(jsonPath("category").value("categ1"));

    }

    @Test
    public void getArticle_notFound() throws Exception {
        given(articleService.getArticleDetails(anyString()))
                .willThrow(new ArticleNotFoundException());

        mockMvc.perform(get("/api/articles/titlkk"))
                .andExpect(status().isNotFound());;
    }
}
