package api;

import domain.User;
import fallback.UserServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 *
 *用户访问
 * Created by wxb on 2018/2/27.
 */
// 利用占位符避免未来整合硬编码,否则，未来升级时，不得不升级客户端版本。
@FeignClient(name= "${user.service.name}", fallback = UserServiceFallback.class)
public interface UserService {

    /**
     * 保存用户
     * @param user
     * @return
     */
    @PostMapping("/user/save")
    boolean saveUser(User user);

    /**
     * 查询所有用户列表
     * @return
     */
    @GetMapping("/user/find/all")
    List<User> findAll();
}
