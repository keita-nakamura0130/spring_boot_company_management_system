package com.keita.nakamura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.User;
import com.keita.nakamura.mapper.UserMapper;
import com.keita.nakamura.security.LoginUserDetails;

/***
 * ログインイン時に認証ユーザーを「employeeテーブル」から情報を取得するクラス
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //入力された名前をキーにemployeeテーブルのレコードを1件取得
        User user = userMapper.findByName(name);

        //該当レコードが取得できなかった場合はエラーにする
        if  (user == null)   {
            throw new UsernameNotFoundException("Wrong email or password");
        }

        //ログインユーザー権限を設定
        String role = "ROLE_ADMIN";

        return new LoginUserDetails(user, role);
    }
}