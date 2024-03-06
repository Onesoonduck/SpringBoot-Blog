package com.example.Springbootblog.controller;

import com.example.Springbootblog.domain.Article;
import com.example.Springbootblog.dto.AddArticleRequest;
import com.example.Springbootblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

        // 요청한 지원이 성공적으로 생성되었으며, 저장된 블로그 글 정보를 응답 객체에 담아 전송
        return ResponseEntity.status(HttpStatus.CREATED) // 응답코드 201 : Created 성공적으로 수행, 새로운 리소스 생성
                .body(savedArticle);
    }

}
