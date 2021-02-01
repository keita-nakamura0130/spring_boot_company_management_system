package com.keita.nakamura.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Companyクラス
 */
@Getter
@Setter
public class Company {
    /**
     * ID
     */
    private int id;

    /**
     * 会社名
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 50, message="50文字以内で入力してください")
    private String name;

    /**
     * 代表者
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 20, message="20文字以内で入力してください")
    private String representative;

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

    /**
     * 引数なしコンストラクタ
     */
    public Company() {

    }

    /**
     * コンストラクタ
     *
     * @param name
     * @param representative
     * @param phoneNumber
     * @param postalCode
     * @param prefectureCode
     * @param address
     * @param mailAddress
     */
    public Company(String name, String representative, String phoneNumber, String postalCode, String prefectureCode, String address, String mailAddress) {
        this.name = name;
        this.representative = representative;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.prefectureCode = prefectureCode;
        this.address = address;
        this.mailAddress = mailAddress;
    }
}
