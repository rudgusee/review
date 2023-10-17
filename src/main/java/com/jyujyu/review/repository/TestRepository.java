package com.jyujyu.review.repository;

import com.jyujyu.review.model.TestingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<TestingEntity, Long>, TestRepositoryCustom {

    public List<TestingEntity> findAllByName(String name);

}
