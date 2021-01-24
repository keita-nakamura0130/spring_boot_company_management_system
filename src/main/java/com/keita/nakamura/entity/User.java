package com.keita.nakamura.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Userクラス
 */
@Getter
@Setter
public class User {

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
