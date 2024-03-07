package com.example.Springbootblog.repository;

import com.example.Springbootblog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Article, Long> { // JpaRepository를 참조함으로 메서드 사용 가능

}
