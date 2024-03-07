package com.example.Springbootblog.controller;

import com.example.Springbootblog.domain.Article;
import com.example.Springbootblog.dto.AddArticleRequest;
import com.example.Springbootblog.dto.ArticleResponse;
import com.example.Springbootblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticle () {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()  // 스트림은 여러 데이터가 모여있는 컬렉션을 간편하게 처리하기 위한 기능 (java 8 추가)
                .map(ArticleResponse::new)
                .toList();

        return ResponseEntity.ok()
                .body(articles);
    }

    // @PathVariable 은 URL에서 값을 가져오는 애너테이션
    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> findArticle (@PathVariable long id) {
        Article article = blogService.findById(id);

        // findById로 id 를 찾고 body에 담아 웹 브라우저로 전송
        return ResponseEntity.ok()
                .body(new ArticleResponse(article));
    }

    @DeleteMapping("/api/article/{id}") // {id} 에 해당하는 값이 id로 들어옴
    public ResponseEntity<Void> deleteArticle (@PathVariable long id) {
        blogService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

}
