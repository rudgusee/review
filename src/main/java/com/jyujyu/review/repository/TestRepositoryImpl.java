package com.jyujyu.review.repository;

import com.jyujyu.review.model.QTestingEntity;
import com.jyujyu.review.model.TestingEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class TestRepositoryImpl implements TestRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<TestingEntity> findAllByNameByQuerydsl(String name) {
        return queryFactory.selectFrom(QTestingEntity.testingEntity)
                .fetch();
    }
}
