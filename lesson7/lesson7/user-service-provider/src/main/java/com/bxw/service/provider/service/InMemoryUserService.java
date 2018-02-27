package com.bxw.service.provider.service;

import api.UserService;
import domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存实现
 * Created by wxb on 2018/2/27.
 */
@Service
public class InMemoryUserService implements UserService {

    private Map<Long, User> map = new ConcurrentHashMap<>();

    @Override
    public boolean saveUser(User user) {
        return map.put(user.getId(), user) == null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(map.values());
    }
}
