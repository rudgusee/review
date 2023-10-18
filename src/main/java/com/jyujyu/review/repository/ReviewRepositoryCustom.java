package com.jyujyu.review.repository;

import com.jyujyu.review.model.ReviewEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

public interface ReviewRepositoryCustom {

    Double getAvgScoreByRestaurantId(Long restaurantId);

    //paging 기법에 사용하는 인터페이스
    Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page);


}
