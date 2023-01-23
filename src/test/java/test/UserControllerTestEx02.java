package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 컨트롤러 테스트를 위한 @WebMvcTest 어노테이션을 제공하고 있다.
 * 이를 이용하면 MockMvc 객체가 자동으로 생성될 뿐만 아니라
 * ControllerAdvice나 Filter, Interceptor 등 웹 계층 테스트에 필요한 요소들을 모두 빈으로 등록해 스프링 컨텍스트 환경을 구성한다.
 * @WebMvcTest는 스프링부트가 제공하는 테스트 환경이므로 @Mock과 @Spy 대신 각각 @MockBean과 @SpyBean을 사용해주어야 한다.
 */
@WebMvcTest(UserController.class)
public class UserControllerTestEx02 {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;
}
