개념정리

@Autowired / @RequiredArgsConstructor
의존성 주입은 여러 방법으로 할 수 있지만 @Autowired 를 통한 필드 주입과 
@RequiredArgsConstructor 를 통한 생성자 주입이 있다.
하지만 순환 참조 방지 , 객체 변이 방지 등의 이유로 spring 에서는 생성자 주입을 권장한다고 한다.
실제로 초기에 스프링을 배울 때를 제외하고는 @Autowired 는 거의 사용하지 않은 것 같다.
