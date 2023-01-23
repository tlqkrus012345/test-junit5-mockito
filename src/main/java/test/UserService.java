package test;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public UserResponse signUp(UserRequest userRequest) {
        return new UserResponse("ASDF", "123");
    }

    public List<UserResponse> findAll() {
        return new ArrayList<>();
    }
}
