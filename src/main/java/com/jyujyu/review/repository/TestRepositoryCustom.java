package com.jyujyu.review.repository;

import com.jyujyu.review.model.TestingEntity;

import java.util.List;

public interface TestRepositoryCustom {

    public List<TestingEntity> findAllByNameByQuerydsl(String name);
}
