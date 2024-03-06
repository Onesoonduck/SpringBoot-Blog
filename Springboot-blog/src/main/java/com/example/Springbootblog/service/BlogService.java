package com.example.Springbootblog.service;

import com.example.Springbootblog.domain.Article;
import com.example.Springbootblog.dto.AddArticleRequest;
import com.example.Springbootblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 빈으로 등록
@RequiredArgsConstructor // final이 붙거나 @NotNull이 붙은 빌드의 생성자 생략
public class BlogService {

    private final BlogRepository blogRepository;

    // 블로그 글 추가 메서드
    public Article save (AddArticleRequest request) {
        return blogRepository.save(request.toEntity()); // AddArticleRequest 에 저장이 된 값을 Article DB에 저장하는 메서드
    }

    // findAll() 메서드를 호출해 Article 테이블에 저장되어 있는 모든 데이터 조회
    public List<Article> findAll () {
        return blogRepository.findAll();
    }
}
