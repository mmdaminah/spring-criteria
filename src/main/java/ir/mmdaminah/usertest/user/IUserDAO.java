package ir.mmdaminah.usertest.user;

import java.util.List;

public interface IUserDAO {
    List<User> searchUser(List<SearchCriteria> params);

    void save(User user);
}
