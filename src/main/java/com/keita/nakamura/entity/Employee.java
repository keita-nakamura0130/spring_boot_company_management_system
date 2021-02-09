package com.keita.nakamura.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    private Integer id;

    /**
     * 会社ID
     */
    @NotNull(message ="必須入力です")
    private Integer companyId;

    /**
     * 役職ID
     */
    @NotNull(message ="必須入力です")
    private Integer positionId;

    /**
     * 部署ID
     */
    @NotNull(message ="必須入力です")
    private Integer departmentId;

    /**
     * 雇用形態ID
     */
    @NotNull(message ="必須入力です")
    private Integer employmentStatusId;

    /**
     * 都道府県ID
     */
    @NotNull(message ="必須入力です")
    @Max(47)
    private Integer prefectureId;

    /**
     * 社員名
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 20, message="20文字以内で入力してください")
    private String name;

    /**
     * 生年月日
     */
    @NotBlank(message = "必須入力です")
    @Pattern(regexp="^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$", message="正しい年月日(yyyy/MM/dd)の形式で入力してください")
    private String birthday;

    /**
     * 性別
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 1, message="正しく選択してください")
    private String sex;

    /**
     * 血液型
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 1, message="正しく選択してください")
    private String blood;

    /**
     * 電話番号
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 11, message="11文字以内で入力してください")
    @Pattern(regexp="^0\\d{9,10}$", message="電話番号形式(ハイフン無し)で入力してください")
    private String phoneNumber;

    /**
     * 郵便番号
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 7, message="7文字以内で入力してください")
    @Pattern(regexp="^[0-9]{7}$", message="郵便番号形式(ハイフン無し)で入力してください")
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
    @NotBlank(message = "必須入力です")
    @Pattern(regexp="^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$", message="正しい年月日(yyyy/MM/dd)の形式で入力してください")
    private String joinDate;

    /**
     * 退職日
     */
    @NotBlank(message = "必須入力です")
    @Pattern(regexp="^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])$", message="正しい年月日(yyyy/MM/dd)の形式で入力してください")
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
