# 블로그 백엔드 서버 만들기

스프링 부트 기반 CRUD기능 구현하기

1. 전체 게시글 목록 조회 API
    - 제목, 작성자명, 작성 날짜를 조회하기
    - 작성 날짜 기준으로 내림차순 정렬하기
2. 게시글 작성 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 입력하기
3. 게시글 조회 API
    - 제목, 작성자명, 작성 날짜, 작성 내용을 조회하기
4. 게시글 비밀번호 확인 API
    - 비밀번호를 입력 받아 해당 게시글의 비밀번호와 일치여부 판단하기
5. 게시글 수정 API
    - 제목, 작성자명, 비밀번호, 작성 내용을 수정되게 하기
6. 게시글 삭제 API
    - 글이 삭제되게 하기

![](https://velog.velcdn.com/images/yuns8708/post/b28262cf-c14c-40c9-8b1e-a9869c68727d/image.jpg)

---

### API Request - param, query, body

Request 객체는 API를 컨트롤하기 위한 메소드가 세가지 있는데, 본 프로젝트는 수정, 삭제 API의 request로 body와 param이 사용되었다.

- param : 주소에 포함된 변수를 담는다 (path variable)
- query : 주소 바깥 ? 이후의 변수를 담는다 (query parameter)
- body : XML, JSON, Multi Form 등의 데이터를 담는다. 주소에서 확인할 수 없다.

resource를 식별해야할 때에는 path variable이 적합하고,

정렬이나 필터링을 해야할 때에는 query parameter이 더 적절하다.

---

### REST API
REST API란 REST의 원리를 따르는 API로, RESTful하게 API를 설계하려면 REST의 설계 규칙을 올바르게 지키고 적절한 Method를 사용해야한다.

### REST API 설계 규칙
- URI는 동사보다 명사, 대문자보다는 소문자를 사용한다
- 마지막에 슬래시/를 포함하지 않는다.
- 언더바 대신 하이픈을 사용한다
- 파일확장자를 URI에 포함하지 않는다. (.jpg등)
- 행위를 포함하지 않는다 (delete-post x / post o)

---

### Controller, Service, Repository의 분리
Controller에서 모든 응답을 처리하게 만들 수 있는데, 굳이 나눠서 사용하는 이유는 무엇일까?

- 한 개의 클래스에 너무 많은 양의 코드가 존재하면 가독성이 떨어지기 때문에 나눔
- 코드 추가 혹은 변경이 생길 때, 모듈화가 되어있으면 변경이 쉬움
- 객체 지향 프로그래밍의 특징 - 각각의 모듈이 각각의 작업만을 수행하는 것이 중요함
