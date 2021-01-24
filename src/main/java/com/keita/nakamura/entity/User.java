package com.keita.nakamura.entity;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import lombok.Getter;
import lombok.Setter;

/**
 * Userクラス
 */
@Getter
@Setter
public class User {
    public User() {
        
    }

    public User(String name2, String encode, List<GrantedAuthority> grantList) {
        // TODO 自動生成されたコンストラクター・スタブ
    }

    /**
     * ID
     */
    private Integer id;

    /**
     * ユーザー名
     */
    private String name;

    /**
     * パスワード
     */
    private String password;

    /**
     * 作成日時
     */
    private String created;

    /**
     * 更新日時
     */
    private String modified;

    /**
     * 削除日時
     */
    private String deleted;
}
