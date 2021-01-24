package com.keita.nakamura.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.User;

/**
 * Userマッパー
 */
@Mapper
public interface UserMapper {
    /**
     * ユーザー名よりユーザーを1件取得
     *
     * @param name
     */
    User findByName(String name);
    
    /**
     * ユーザーを追加
     *
     * @param user
     */
    void insert(User user);
}
