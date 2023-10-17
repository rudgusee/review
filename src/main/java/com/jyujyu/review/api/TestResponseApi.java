package com.jyujyu.review.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseApi {

    @GetMapping("/test/response/string")
    public String stringResponse() {
        return "This is String";
    }

//    @GetMapping("/test/response/json")
//    public String jsonResponse() {
//        return "{\"name\": \"This is Json\"}";
//    }

    @GetMapping("/test/response/json")
    public TestResponseBody jsonResponse() {
        return new TestResponseBody("최강새우", 20);
    }

    //원하는 데이터를 만들어 객체를 리턴
    public static class TestResponseBody {
        String name;
        Integer age;


        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }


        //Request Body 방식을 사용하기 위해서는 생성자를 꼭 만들어야한다

        public TestResponseBody(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
