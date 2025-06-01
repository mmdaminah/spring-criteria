package ir.mmdaminah.usertest.user;

import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDataSeeder implements CommandLineRunner {

    private final IUserDAO userDAO;

    public UserDataSeeder(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    public void run(String... args) throws Exception {

        userDAO.save(
                User.builder()
                        .firstName("ali")
                        .lastName("alavi")
                        .email("alavi@gmail.com")
                        .age(23)
                        .build()
        );

        userDAO.save(
                User.builder()
                        .firstName("mohammad")
                        .lastName("mohammadi")
                        .email("mohammadi@gmail.com")
                        .age(27)
                        .build()
        );

    }

}
