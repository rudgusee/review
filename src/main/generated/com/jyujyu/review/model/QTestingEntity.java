package com.jyujyu.review.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTestingEntity is a Querydsl query type for TestingEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTestingEntity extends EntityPathBase<TestingEntity> {

    private static final long serialVersionUID = -72032359L;

    public static final QTestingEntity testingEntity = new QTestingEntity("testingEntity");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QTestingEntity(String variable) {
        super(TestingEntity.class, forVariable(variable));
    }

    public QTestingEntity(Path<? extends TestingEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTestingEntity(PathMetadata metadata) {
        super(TestingEntity.class, metadata);
    }

}

