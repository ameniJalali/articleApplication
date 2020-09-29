package com.github.article;

import com.github.article.entity.Article;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
class ArticleApplicationTests {

    /*@Test
    void contextLoads() {
    }*/

    @Autowired
    public TestRestTemplate testRestTemplate;

    @Test
    public void  shouldReturnArticle () throws Exception {
        //given

        //when

        ResponseEntity<Article> responseEntity= testRestTemplate
                .getForEntity("api/articles/titlkk" , Article.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getTitle()).isEqualTo("titlkk");
        assertThat(responseEntity.getBody().getCategory()).isEqualTo("categ1");


    }



}
