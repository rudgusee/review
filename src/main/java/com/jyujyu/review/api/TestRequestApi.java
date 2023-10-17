package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestRequestApi {

    //Request Parameter 방식
    //서버에 값을 넣어 api를 호출하는 방식
    //param 정의는 requestparam에 맞는 param을 보내줘야 메소드가 정삭적으로 호출될 수 있다.
    @GetMapping("/test/param")
    public String requestParam(@RequestParam("name") String name,
                               @RequestParam("age") Integer age) {
        return "Hello, Request Param, I am " + name + " , " + age;
    }

    //Path Variable 방식: path를 변수처럼 사용한다는 의미
    //Path: http://localhost:8080 이후의 부분
    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(@PathVariable("name") String name,
                                      @PathVariable("age") Integer age) {
        return "Hello, Path Variable, I am " + name + " , " + age;
    }

    //Request Body
    //post, put mapping 에서 자주 쓰임
    @PostMapping("/test/body")
    public String requestBody(@RequestBody TestRequestBody request) {
        return "Hello, Request Body, I am " + request.name + " , " + request.age;
    }

    public static class TestRequestBody {
         String name;
         Integer age;

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public TestRequestBody () {}

        //Request Body 방식을 사용하기 위해서는 생성자를 꼭 만들어야한다
//        public TestRequestBody(String name, Integer age) {
//            this.name = name;
//            this.age = age;
//        }
    }

}
