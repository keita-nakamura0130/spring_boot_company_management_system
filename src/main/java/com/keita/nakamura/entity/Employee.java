package com.keita.nakamura.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Employeeクラス
 */
@Getter
@Setter
public class Employee {
    /**
     * ID
     */
    private int id;

    /**
     * 会社ID
     */
    private int companyId;

    /**
     * 従業員名
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 50, message="50文字以内で入力してください")
    private String name;

    /**
     * 部署
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 20, message="20文字以内で入力してください")
    private String department;

    /**
     * 電話番号
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 11, message="11文字以内で入力してください")
    private String phoneNumber;

    /**
     * 郵便番号
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 7, message="7文字以内で入力してください")
    private String postalCode;

    /**
     * 都道府県コード
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 2, message="選択してください")
    private String prefectureCode;

    /**
     * 住所
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 100, message="100文字以内で入力してください")
    private String address;

    /**
     * メールアドレス
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 100, message="100文字以内で入力してください")
    @Email(message = "メール形式で入力してください")
    private String mailAddress;

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
