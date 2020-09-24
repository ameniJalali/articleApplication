package com.github.article;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.article.controller.ArticleController;
import com.github.article.entity.Article;
import com.github.article.services.ArticleService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ArticleController.class)
@ActiveProfiles("test")
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Autowired
    private ObjectMapper objectMapper;

    private List<Article> articleList;

    @Before
   public  void setUp() {
        this.articleList = new ArrayList<>();
        this.articleList.add(new Article(1L, "pwd1","User1"));
        this.articleList.add(new Article(2L, "pwd2","User2"));
        this.articleList.add(new Article(3L, "pwd3","User3"));
    }

    @Test
    public void shouldFetchAllArticles() throws Exception {
        given(articleService.getAllArticles()).willReturn(this.articleList);

        this.mockMvc.perform(get("/api/articles"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturn404WhenFetchingNonExistingArticle() throws Exception {
        Long articleId = 1L;
        given(articleService.getArticleById(articleId)).willReturn(Optional.empty());

        this.mockMvc.perform(get("/api/articles/{id}", articleId))
                .andExpect(status().isNotFound());

    }
}
