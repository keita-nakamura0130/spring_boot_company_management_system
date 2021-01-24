package com.keita.nakamura.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.User;
import com.keita.nakamura.security.LoginUserDetails;

/**
 * ログイン時にユーザーをUsersテーブルから情報を取得するクラス
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    /**
     * ユーザーをロードする
     */
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userService.findByName(name);

        //該当レコードが取得できなかった場合はエラーにする
        if (user == null) {
            throw new UsernameNotFoundException("ユーザー名かパスワードが誤りです。");
        }

        //ログインユーザー権限を設定
        String role = "ROLE_ADMIN";

        return new LoginUserDetails(user, role);
    }
}
