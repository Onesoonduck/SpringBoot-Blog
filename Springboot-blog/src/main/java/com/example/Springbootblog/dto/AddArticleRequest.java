package com.example.Springbootblog.dto;

import com.example.Springbootblog.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 기본 생성자 생략
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddArticleRequest {

    private String title;
    private String content;

    public Article toEntity() { // 빌더 패턴을 사용해 DTO를 엔티티로 만들어줌
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}
