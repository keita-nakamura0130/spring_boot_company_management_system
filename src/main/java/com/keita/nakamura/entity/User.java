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

    /**
     * 引数なしコンストラクタ
     */
    public User() {

    }

    /**
     * コンストラクタ
     *
     * @param name
     * @param encode
     * @param grantList
     */
    public User(String name, String encode, List<GrantedAuthority> grantList) {

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
