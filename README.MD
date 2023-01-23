## 단위 테스트 , 통합 테스트

#### 단위 테스트(Unit Test)
- 단위 테스트는 하나의 모듈을 기준으로 독립적으로 진행되는 가장 작은 단위의 테스트이다.
- 여기서 모듈은 애플리케이션에서 작동하는 하나의 기능 또는 메소드 (ex : 로그인 메소드에 대한 독립적인 테스트가 1개의 단위테스트)
- 통합 테스트에서 데이터베이스 등 다른 컴포넌트들과 연결하는 과정 없이 특정 부부만 독립적으로 테스트하기에 
시간과 비용을 절감할 수 있으며, 새로운 기능 추가 시에 수시로 빠르게 테스트가 가능하다.
- 일반적인 애플리케이션은 1개의 기능을 처리하기 위해 다른 객체들과 통신을 한다. 단위테스트는 1개의 기능에 대한
독립적인 테스트를 진행한다. 이러한 문제점을 해결하기 위해 가짜 객체(Mock)을 주입한다.

#### 통합 테스트(Integration Test)
- 통합 테스트는 모듈을 통합하는 과정에서 모듈 간의 호환성을 확인하기 위해 수행되는 테스트이다.

#### Junit5, AssertJ
- 자바 단위 테스트를 위한 프레임워크, 가독성이 좋은 AssertJ 라이브러리.

---

#### Mock 이란 
- 진짜 객체와 비슷하게 동작하지만 프로그래머가 직접 그 객체의 행동을 관리하는 객체

#### Mockito 이란
- Mock 객체를 쉽게 만들고 관리하고 검증할 수 있는 방법을 제공하는 프레임워크.

#### Mockito와 Junit
- ExtendWith(MockitoExtension.class)를 사용해야 같이 사용이 가능하다.

#### Mockito 사용방법
- Mock 객체 의존성 주입
  - @Mock : Mock 객체를 만들어 반환해주는 어노테이션
  - @Spy : Stub하지 않은 메소드들은 원본 메소드 그대로 사용하는 어노테이션
  - @InjectMock : @Mock 또는 @Spy로 생성된 가짜 객체를 자동으로 주입시켜주는 어노테이션
- UserController에 대한 단위 테스트를 작성하고자 할 때, UserService를 사용해야 하면 
@Mock 으로 가짜 UserService를 만들고 @InjectMock를 통해 UserController에 이를 주입시킨다.

#### Stub로 결과 처리
- doReturn(): Mock 객체가 특정한 값을 반환해야 하는 경우
- doNothing(): Mock 객체가 아무 것도 반환하지 않는 경우(void)
- doThrow(): Mock 객체가 예외를 발생시키는 경우

#### MockMvc

- 웹 API 테스트할 때 사용한다.
- 스프링 MVC 테스트의 시작점이다
- 이 클래스를 통해 HTTP 통신에 대한 API 테스트를 할 수 있다.
- mockmvc.perform(get("~@")) ~@ 주소로 get요청을 한다.
- .andExpect(status().isOk()) : http header의 status를 검증한다.
- .andExpect(content.string(hello)) : 응답 본문의 내용을 검증한다.

#### @WebMvcTest

- 스프링 테스트 어노테이션 중, Web(Spring MVC)에 집중할 수 있는 어노테이션

#### @DataJpaTest
- JPA에 집중한 테스트이다.
- 인메모리 데이터베이스를 사용하며 테스트가 끝나면 롤벡된다.. 

- https://www.baeldung.com/?s=junit5
- https://site.mockito.org/
- https://mangkyu.tistory.com/143