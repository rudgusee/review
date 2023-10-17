package com.jyujyu.review.api;

import com.jyujyu.review.model.TestingEntity;
import com.jyujyu.review.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TestQueryApi {

    private final TestService testService;

    @GetMapping("/test/query/jpa")
    public List<TestingEntity> queryJpa() {
        return testService.findAllByNameByJPA("최강새우");
    }

    @GetMapping("/test/query/querydsl")
    public List<TestingEntity> queryQuerydsl() {
        return testService.findAllByNameByQuerydsl("최강새우");
    }

}
