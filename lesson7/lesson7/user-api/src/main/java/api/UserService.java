package api;

import domain.User;

import java.util.List;

/**
 * Created by wxb on 2018/2/27.
 */
public interface UserService {
    boolean saveUser(User user);
    List<User> findAll();
}
