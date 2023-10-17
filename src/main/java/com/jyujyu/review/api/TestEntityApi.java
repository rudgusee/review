package com.jyujyu.review.api;

import com.jyujyu.review.service.TestService;
import lombok.*;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TestEntityApi {

    private final TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.create(request.getName(), request.getAge());
    }

    @PutMapping("/test/entity/{id}")
    public void putTestEntity(
            @PathVariable Long id,
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.update(id, request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable Long id
    ) {
        testService.delete(id);
    }


    @NoArgsConstructor
    @AllArgsConstructor
    @Setter
    @Getter
    public static class CreateTestEntityRequest {
        private String name;
        private Integer age;
    }

}
