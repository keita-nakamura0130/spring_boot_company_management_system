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
     * 役職ID
     */
    private int position_id;

    /**
     * 部署ID
     */
    private int department_id;

    /**
     * 雇用形態ID
     */
    private int employment_status_id;

    /**
     * 都道府県ID
     */
    private int prefecture_id;

    /**
     * 社員名
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 20, message="20文字以内で入力してください")
    private String name;

    /**
     * 生年月日
     */
    private String birthday;

    /**
     * 性別
     */
    private String sex;

    /**
     * 血液型
     */
    private String blood;

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
     * 入社日
     */
    private String joinDate;

    /**
     * 退職日
     */
    private String retirementDate;

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
