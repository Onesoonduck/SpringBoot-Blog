package com.example.Springbootblog.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter // 게터 어노테이션으로 get 메소드 생략
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 생략
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키를 자동으로 1씩 증가
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // 'title' 이라는 not null 컬럼과 매칭
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder // 빌더 패턴으로 객체 생성
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
