package com.example.Springbootblog.controller;

import com.example.Springbootblog.domain.Article;
import com.example.Springbootblog.dto.AddArticleRequest;
import com.example.Springbootblog.repository.BlogRepository;
import com.example.Springbootblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // HTTP Response Body 에 객체 데이터를 JSON 형식으로 반환하는 컨트롤러 명시
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    //HTTP 메서드가 POST일 때 전달받은 URL과 동일하면 메서드로 매핑
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody AddArticleRequest request) {
        Article savedArticle = blogService.save(request);
    }
}
