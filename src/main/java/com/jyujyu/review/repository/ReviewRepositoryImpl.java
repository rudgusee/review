package com.jyujyu.review.repository;

import com.jyujyu.review.model.QReviewEntity;
import com.jyujyu.review.model.ReviewEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.SliceImpl;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    //평균 별점을 구하는 메소드
    //어떤 맛집에 등록된 리뷰들의 평균 별점을 가져오는 쿼리
    @Override
    public Double getAvgScoreByRestaurantId(Long restaurantId) {
        return queryFactory.select(QReviewEntity.reviewEntity.score.avg()) //reviewEntity의 점수의 평균을 낸다.
                .from(QReviewEntity.reviewEntity) //reviewEntity에서 평균을 낸다.
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId)) //reviewEntity 중에 알고싶은 맛집에 등록된 리뷰들의 점수
                .fetchFirst();
    }

    @Override
    public Slice<ReviewEntity> findSliceByRestaurantId(Long restaurantId, Pageable page) {

        List<ReviewEntity> reviews = queryFactory.select(QReviewEntity.reviewEntity)
                .from(QReviewEntity.reviewEntity)
                .where(QReviewEntity.reviewEntity.restaurantId.eq(restaurantId))
                .offset((long) page.getPageNumber() * page.getPageSize()) // offset 10개씩 가져와라
                .limit(page.getPageSize() + 1)
                .fetch();

        return new SliceImpl<>(
                reviews.stream().limit(page.getPageSize()).toList(),
                page,
                reviews.size() > page.getPageSize() //page size가 요청한 페이지 사이즈보다 더 큰지 확인해봐야한다.
        );

    }
}
