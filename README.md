[쥬쥬와 함께하는 하루만에 시작하는 백엔드 - 스프링, 도커, AWS 를 강의를 시청하고 만든 프로젝트입니다]

## 기획 의도
맛집을 관리하고 사용자들이 맛집에 방문한 이후에 리뷰를 작성해서 다른 사용자들이 맛집을 방문하기전 리뷰와 평균 별점을 확인할 수 있도록 하는 서비스
맛집마다 리뷰를 작성하거나 삭제할 수 있습니다. 맛집은 이름, 주소, 메뉴를 가지고 있으며 메뉴는 이름과 가격으로 구성됩니다. 리뷰는 본문과 별점을 가지고 있습니다. 맛집은 여러개의 메뉴와 리뷰를 가질 수 있고 리뷰는 메뉴별로는 작성이 불가합니다

## ERD-diagram
![erd](https://github.com/rudgusee/review/assets/80056046/f65c3c9f-7d1a-46a1-8feb-adc6bd0e909f)

API Spec

### 맛집 리스트 가져오기 API

GET /restaurants

// response
[
  {
    "id": Long,
    "name": string,
    "address": string,
    "createdAt": string,
    "updatedAt": string
  },
  ...
}



### 맛집 정보 가져오기 API

GET /restaurant/{restaurantId}

// response
{
  "id": Long,
  "name": string,
  "address": string,
  "createdAt": string,
  "updatedAt": string,
  "menus": [
    {"id": Long, "name": string, "price": int, "createdAt": string, "updatedAt": string},
    {"id": Long, "name": string, "price": int, "createdAt": string, "updatedAt": string},
    ...
  ]
}  




### 맛집 생성 API

POST /restaurant
{
  "name": string,
  "address": string,
  "menus": [
    {"name": string, "price": int},
    ...
  ]
}




### 맛집 수정 API

PUT /restaurant/{restaurantId}
{
  "name": string,
  "address": string,
  "menus": [
    {"name": string, "price": int},
    ...
  ]
}




### 맛집 삭제 API

DELETE /restaurant/{restaurantId}




### 리뷰 작성 API

POST /review
{
  "restaurantId": int,
  "content": string,
  "score": float
}

### 리뷰 삭제 API

DELETE /review/{reviewId}




### 맛집에 등록된 리뷰 가져오기 API

GET /restaurant/{restaurantId}/reviews

// response
{
  "avgScore": float, // 평균 별점
  "reviews": [
    {"id": int, "content": string, "score": float, "createdAt": string},
    {"id": int, "content": string, "score": float, "createdAt": string},
    {"id": int, "content": string, "score": float, "createdAt": string}
  ],
  "page": {
    "offset": int,
    "limit": int
  }
}
