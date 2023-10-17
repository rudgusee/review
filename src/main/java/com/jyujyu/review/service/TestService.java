package com.jyujyu.review.service;

import com.jyujyu.review.model.TestingEntity;
import com.jyujyu.review.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor //1. lombok(o) @AllArgsConstructor //2. lombok(x) TestService 생성자 직접생성
public class TestService {

    //testRepository를 어딘가에 저장해야하는데 스프링이 자동으로 해줌
    // 1. @AllArgsConstructor 2. 생성자 생성
    private final TestRepository testRepository;

    public void create(String name, Integer age) {
        TestingEntity testingEntity = new TestingEntity(name, age);
        testRepository.save(testingEntity);
    }

    public void delete(Long id) {
        TestingEntity testingEntity = testRepository.findById(id).get();
        testRepository.delete(testingEntity);
    }

    public void update(Long id, String name, Integer age){
        TestingEntity testingEntity = testRepository.findById(id).orElseThrow();
        testingEntity.changeNameAndAge(name, age);
        testRepository.save(testingEntity);
    }

    public List<TestingEntity> findAllByNameByJPA(String name) {
        return testRepository.findAllByName(name);
    }

    public List<TestingEntity> findAllByNameByQuerydsl(String name) {
        return testRepository.findAllByNameByQuerydsl(name);
    }

}
