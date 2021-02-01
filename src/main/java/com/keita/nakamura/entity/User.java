package com.keita.nakamura.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

/**
 * Userクラス
 */
@Getter
@Setter
public class User implements UserDetails {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 引数なしコンストラクタ
     */
    public User() {

    }

    /**
     * コンストラクタ
     *
     * @param name
     * @param password
     * @param grantList
     */
    public User(String name, String password, List<GrantedAuthority> grantList) {

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

    /**
     *
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return null;
    }

    /**
     *
     */
    @Override
    public String getUsername() {

        return null;
    }

    /**
     *
     */
    @Override
    public boolean isAccountNonExpired() {

        return false;
    }

    /**
     *
     */
    @Override
    public boolean isAccountNonLocked() {

        return false;
    }

    /**
     *
     */
    @Override
    public boolean isCredentialsNonExpired() {

        return false;
    }

    /**
     *
     */
    @Override
    public boolean isEnabled() {

        return false;
    }
}
