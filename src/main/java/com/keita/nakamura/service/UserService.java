package com.keita.nakamura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.User;
import com.keita.nakamura.mapper.UserMapper;

/**
 * Userサービス
 */
@Service
public class UserService  {
    @Autowired
    UserMapper userMapper;

    /**
     * ユーザー名よりをユーザーを1件取得
     *
     * @param name
     * @return
     */
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

    /**
     * ユーザーを追加
     *
     * @param user
     */
    public void insert(User user) {
        userMapper.insert(user);
    }
}
