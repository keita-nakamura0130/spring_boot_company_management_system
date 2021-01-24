package com.keita.nakamura.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * LoginUserDetailsクラス
 */
@Data
//equals()とhashCode()を生成するが親クラスのメソッドは呼び出さない
@EqualsAndHashCode(callSuper = false)
public class LoginUserDetails extends User {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    /**
     * Userエンティティ
     */
    private final com.keita.nakamura.entity.User user;

    /**
     * 認証処理コンストラクタ
     *
     * @param user
     * @param role
     */
    public LoginUserDetails(com.keita.nakamura.entity.User user, String role) {
        super(user.getName(), user.getPassword(), AuthorityUtils.createAuthorityList(role));
        this.user = user;
    }
}
