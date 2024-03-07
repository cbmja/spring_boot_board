개념정리

@Autowired / @RequiredArgsConstructor

의존성 주입은 여러 방법으로 할 수 있지만 @Autowired 를 통한 필드 주입과 
@RequiredArgsConstructor 를 통한 생성자 주입이 있다.
하지만 순환 참조 방지 , 객체 변이 방지 등의 이유로 spring 에서는 생성자 주입을 권장한다고 한다.
실제로 초기에 스프링을 배울 때를 제외하고는 @Autowired 는 거의 사용하지 않은 것 같다.

ORNM / bject Relational Mapping 

sql문을 사용하지 않고 자바 문법으로 DB를 다루는 도구.
oracleDB , MS sql 등등 DBSM의 종류에 상관없이 java 코드만을 사용하여 코드 사용이 가능하여 유지보수에 용이.

JPA / Java Persistence API

spring boot 에서 사용하는 ORM 기술 표준.
jpa는 인터페이스 모음이고, 실제로는 구현한 클래스를 사용하는데 보통 하버네이트를 사용.
정리하자면  하버네이트는 jpa를 구현한 실제 클래스이며 자바의 ORM프레임 워크이다.
