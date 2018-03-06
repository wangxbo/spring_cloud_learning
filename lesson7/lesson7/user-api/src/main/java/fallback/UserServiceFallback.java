package fallback;

import api.UserService;
import domain.User;

import java.util.Collections;
import java.util.List;

/**
 * {@link api.UserService} Fallback实现
 * Created by wxb on 2018/3/6.
 */
public class UserServiceFallback implements UserService{
    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }
}
