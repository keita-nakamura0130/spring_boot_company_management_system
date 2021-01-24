package com.keita.nakamura.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.User;
import com.keita.nakamura.mapper.UserMapper;

/**
 * Companyサービス
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserMapper UserMapper;

    /**
     * ユーザー名よりをユーザーを1件取得
     *
     * @param name
     * @return
     */
    public User findByName(String name) {
        return UserMapper.findByName(name);
    }
    
    /**
     * ユーザーを追加
     *
     * @param user
     */
    public void insert(User user) {
        UserMapper.insert(user);
    }
    
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = UserMapper.findByName(name);
        System.out.println("LOGINUSER INSTANCE");
 
        if (user == null) {
            throw new UsernameNotFoundException("userName" + name + "was not found in the database");
        }
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("USER");
        grantList.add(authority);
 
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
 
        UserDetails userDetails = (UserDetails) new User(user.getName(), encoder.encode(user.getPassword()), grantList);
        return userDetails;
    }
}
