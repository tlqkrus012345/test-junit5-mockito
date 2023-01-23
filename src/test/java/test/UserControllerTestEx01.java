package test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * HTTP 요청을 보내면 Spring은 내부에서 MessageConverter를 사용해 Json String을 객체로 변환한다.
 * 그런데 이것은 Spring 내부에서 진행되므로, 우리가 API로 전달되는 파라미터인 SignUpRequest를 조작할 수 없다.
 * 그래서 SignUpRequest 클래스 타입이라면 어떠한 객체도 처리할 수 있도록 any()가 사용되었다.
 * any()를 사용할 때에는 특정 클래스의 타입을 지정해주는 것이 좋다.
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTestEx01 {


    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    void singUpSuccess() throws Exception {
        UserRequest request = userRequest();
        UserResponse response = userResponse();
        doReturn(response).when(userService)
            .signUp(any(UserRequest.class));

        ResultActions resultActions = mockMvc.perform(
            MockMvcRequestBuilders.post("/users/signUp")
            .contentType(MediaType.APPLICATION_JSON)
            .content(new Gson().toJson(request))
        );

//        MvcResult mvcResult = resultActions.andExpect(status().isOk())
//            .andExpect(jsonPath("email", response.getEmail()).exists())
//            .andExpect(jsonPath("pw", response.getPw()).exists())
//            .andExpect(jsonPath("role", response.getRole()).exists());
    }
    @Test
    void getUserList() throws Exception {
        // given
        doReturn(userList()).when(userService)
            .findAll();

        // when
        ResultActions resultActions = mockMvc.perform(
            MockMvcRequestBuilders.get("/user/list")
        );

        // then
        MvcResult mvcResult = resultActions.andExpect(status().isOk()).andReturn();

        UserListResponseDTO response = new Gson().fromJson(mvcResult.getResponse().getContentAsString(), UserListResponseDTO.class);
        assertThat(response.getUserList().size()).isEqualTo(5);
    }

    private List<UserResponse> userList() {
        List<UserResponse> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            userList.add(new UserResponse("test@test.test", "test", UserRole.USER));
        }
        return userList;
    }
    private UserRequest userRequest() {
        return new UserRequest("as","123");
    }
    private UserResponse userResponse() {
        return new UserResponse("as","43", UserRole.USER);
    }
}