package test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.web.WebAppConfiguration;

@DataJpaTest

class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void save() {
        User user = new User("asd");

        User saveUser = userRepository.save(user);

        System.out.println(user + "  " + saveUser);
        assertThat(saveUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(saveUser).isEqualTo(user);
        assertThat(saveUser).isSameAs(user);
    }

    @Test
    void find() {
        userRepository.save(new User("as"));

        List<User> userList = userRepository.findAll();

        User findUser = userList.get(0);
        assertThat(userList.size()).isEqualTo(1);
    }

    @Test
    void findEmail() {
        User member = userRepository.save(new User("as"));
        User findMember = userRepository.findByEmail("as").get();

        assertThat(member).isEqualTo(findMember);
    }

    @Test
    void existEmail() {
        User member = userRepository.save(new User("as"));
        assertTrue(userRepository.existsByEmail("as"));
    }
}