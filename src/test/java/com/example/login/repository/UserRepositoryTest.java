package com.example.login.repository;

        import com.example.login.model.User;
        import org.junit.Assert;
        import org.junit.jupiter.api.Test;

        import org.junit.jupiter.api.Test;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
        import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
        import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

        import java.sql.SQLOutput;
        import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;



    @Test
    void findUserByName() {

        String name = "Gustaf";
        User user = userRepository.findByName(name);
        assertThat(user.getName()).isNotEmpty();

    }

    @Test
    void findUserByLastName() {
        String lastName= "Sjölinder";
        User user = userRepository.findByLastName((lastName));
        assertThat(user.getLastName()).isNotEmpty();

    }

    @Test
    void checkIfDoubleMail() {
        List<User> userList = userRepository.findAll();

        boolean doubleMailFound = false;
        for(int i=0;i<userList.size();i++){

            for(int j = i+1;j<userList.size();j++){
                if(userList.get(i).getEmail()==userList.get(j).getEmail())
                {
                    doubleMailFound = true;
                }
            }
        }
        assertThat(doubleMailFound).isFalse();

    }

}