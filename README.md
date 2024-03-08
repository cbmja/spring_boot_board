개념정리

@Autowired / @RequiredArgsConstructor
의존성 주입은 여러 방법으로 할 수 있지만 @Autowired 를 통한 필드 주입과 
@RequiredArgsConstructor 를 통한 생성자 주입이 있다.
하지만 순환 참조 방지 , 객체 변이 방지 등의 이유로 spring 에서는 생성자 주입을 권장한다고 한다.
실제로 초기에 스프링을 배울 때를 제외하고는 @Autowired 는 거의 사용하지 않은 것 같다.

---------------------------------------------------------------------------------------------------------

ORNM / bject Relational Mapping 
sql문을 사용하지 않고 자바 문법으로 DB를 다루는 도구.
oracleDB , MS sql 등등 DBSM의 종류에 상관없이 java 코드만을 사용하여 코드 사용이 가능하여 유지보수에 용이.

---------------------------------------------------------------------------------------------------------

JPA / Java Persistence API
spring boot 에서 사용하는 ORM 기술 표준.
jpa는 인터페이스 모음이고, 실제로는 구현한 클래스를 사용하는데 보통 하버네이트를 사용.
정리하자면  하버네이트는 jpa를 구현한 실제 클래스이며 자바의 ORM프레임 워크이다.

---------------------------------------------------------------------------------------------------------

@GeneratedValue
strategy = GenerationType.IDENTITY 설정을 해줘야 해당 속성에 대해 순차적인 증가가 가능함.
설정하지 않을경우 @GeneratedValue 어노테이션이 붙은 모든 속성에 차례로 순서가 성성돼서 일정한 값을 가지지 못 함.

---------------------------------------------------------------------------------------------------------

@OneToMany(mappedBy = "OOOOO" , cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
다대일 매핑에서 cascade = CascadeType.REMOVE 설정은 부모 엔티티가 삭제되면 자식 엔티티도 삭제되는 것이다.
게시글이 삭제될 경우 댓글도 같이 삭제 시킨다거나 할 때 유용하게 사용.
fetch = FetchType.LAZY 이건 수업시간에 귀가 닳도록 들어서 좀 익숙하다. 처음부터 list에 들어갈 자식 객체를 select 하지 않고 실제로 사용하는 시점에 
select 쿼리를 날려주도록 하는 설정이다. mappedBy = "OOOOO" 참조한 속성명.

---------------------------------------------------------------------------------------------------------

 JpaRepository<Entity,ID>
 CRUD작업이 가능한 메서드를 내장하고 있는 인터페이스.
 
 ---------------------------------------------------------------------------------------------------------
 
 JUnit
 본래 사용자가 폼을 통해 정보를 입력하면 컨트롤러에서 서비스 클래스를 통해 CRUD가 작동하는것이 일반적이지만 JUnit을 이용하여 test 코드를 통해 
 레퍼지토리만 개별적으로 동작시킬 수 있다. JUnit = 테스트 코드를 실행할 때 사용하는 자바의 프레임워크
 
 ---------------------------------------------------------------------------------------------------------
 
Repository 메서드 추가
기본으로 제공되는 findAll() , findById() 이외의 select 문이 필요하다면 레포지토리에 직접 메서드를 작성할 수 있다. 마이바티스랑 비슷 하다고 느낌
select subject from boardData; -> 게시글에서 특정 제목으로 찾고 싶다면 래퍼지토리에 
BoardData findBySubject(String subject) 리턴타입 메서드명(매개변수)
같은 방식으로 생성하면 된다. 메서드명은 findBy + '앤티티 속성명' 이어야함.
sql안한지 오래돼서 추가하자면 like 문을 추가하고 싶다면 BoardData findBySubjectLike(String subject) 이렇게 하면 되고,
매개변수는 "%검색어%" 이런 식으로 넣어줘야함
더 다양한 쿼리는 https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html 참조

---------------------------------------------------------------------------------------------------------

Optional<OOO>
NPE 방지를 위한 래퍼 클래스 -> null 값이면 Empty 라는 빈 객체를 주입해줘서 NPE를 방지해 줌.
근데 그냥 초기값을 넣어주는 방법도 있긴 함.

---------------------------------------------------------------------------------------------------------

템플릿 엔진
Html , jsp 등의 템플릿을 통해 응답내용을 클라이언트에게 리턴해주게 되는데 그 안에서 템플릿 양식과 java코드를 학성해 주는 소프트웨어.
thymmeleaf , mustache , groovy , freemarker , velocity 등이 있음.

---------------------------------------------------------------------------------------------------------

DTO
템플릿 엔진에 엔티티 객체를 직접 전달하는 것은 좋은 방법이 아니다.
꼭 service 에서 entity -> DTO 로 변환하는 단계를 거치도록 코드를 작성하자.

---------------------------------------------------------------------------------------------------------

@{|/question/detail/*{id}|}
||로 둘러 싸면 문자열과 java 코드 합성 가능 
"@{/teacher/studyGroup/edit/{num}(num=*{num})}" 기존에 쓰던 방식보다 단결해서 좋은듯

---------------------------------------------------------------------------------------------------------

값을 검증하고 예외처리를 하기 위해서는 예외 클래스 만드는 법을 좀 공부해야 할 듯 하다

---------------------------------------------------------------------------------------------------------

<link rel="stylesheet" type="text/css" th:href="@{/style.css}">
rel 속성값 / type 파일 타입 / href 경로 루트 디렉토리 -> static

---------------------------------------------------------------------------------------------------------

bootstrap
html / css 등을 편하게 사용할 수 있게 해주는 프레임워크.
미리 만들어진 css파일을 가져다가 규칙에 맞게 적용시키기만 하면 됨. 조금만 공부하면 혼자서도 간단한 퍼블리싱은 가능할듯

---------------------------------------------------------------------------------------------------------

"*{#temporals.format(createDate (객체),'yyyy-mm-dd HH:mm (원하는 포멧)')}"
타임리프에서 제공하는 포메터인듯

---------------------------------------------------------------------------------------------------------

"question, loop : ${questionList}" th:object="${question}"
each list 출력 시 융용하게 사용할 수 있는 loop 객체
loop.index - 반복 순서, 0부터 1씩 증가
loop.count - 반복 순서, 1부터 1씩 증가
loop.size - 반복 객체의 요소 갯수 (예: questionList의 요소 갯수)
loop.first - 루프의 첫번째 순서인 경우 true
loop.last - 루프의 마지막 순서인 경우 true
loop.odd - 루프의 홀수번째 순서인 경우 true
loop.even - 루프의 짝수번째 순서인 경우 true
loop.current - 현재 대입된 객체 (예: 위의 경우 question과 동일)

---------------------------------------------------------------------------------------------------------

타임리프 레이아웃은 조금 익숙해질 필요가 있을 듯. 아직은 살짝씩 보지 않고는 조금 헷갈린다. p.146 ~

---------------------------------------------------------------------------------------------------------

validation
입력값을 검증할때 사용하는데 많이 쓰는 어노테이션은 아래와 같음
@Size	문자 길이를 제한한다.
@NotNull	Null을 허용하지 않는다.
@NotEmpty	Null 또는 빈 문자열("")을 허용하지 않는다.
@Past	과거 날짜만 입력할 수 있다.
@Future	미래 날짜만 입력할 수 있다.
@FutureOrPresent	미래 또는 오늘 날짜만 입력할 수 있다.
@Max	최댓값 이하의 값만 입력할 수 있도록 제한한다.
@Min	최솟값 이상의 값만 입력할 수 있도록 제한한다.
@Pattern	입력값을 정규식 패턴으로 검증한다.

---------------------------------------------------------------------------------------------------------


