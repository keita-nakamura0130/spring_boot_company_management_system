package com.keita.nakamura.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Companyクラス
 */
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
     * IDゲッター
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * IDセッター
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 会社名ゲッター
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 会社名セッター
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 代表者ゲッター
     * 
     * @return
     */
    public String getRepresentative() {
        return representative;
    }

    /**
     * 代表者セッター
     * 
     * @param representative
     */
    public void setRepresentative(String representative) {
        this.representative = representative;
    }

    /**
     * 電話番号ゲッター
     * 
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 電話番号セッター
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 郵便番号ゲッター
     * 
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 郵便番号セッター
     * 
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 都道府県ゲッター
     * 
     * @return
     */
    public String getPrefectureCode() {
        return prefectureCode;
    }

    /**
     * 都道府県セッター
     * 
     * @param prefectureCode
     */
    public void setPrefectureCode(String prefectureCode) {
        this.prefectureCode = prefectureCode;
    }

    /**
     * 住所ゲッター
     * 
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * 住所セッター
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * メールアドレスゲッター
     * 
     * @return
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * メールアドレスセッター
     * 
     * @param mailAddress
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * 作成日時ゲッター
     * 
     * @return
     */
    public String getCreated() {
        return created;
    }

    /**
     * 作成日時セッター
     * 
     * @param created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 更新日時ゲッター
     * 
     * @return
     */
    public String getModified() {
        return modified;
    }

    /**
     * 更新日時セッター
     * 
     * @param modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * 削除日時ゲッター
     * 
     * @return
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * 削除日時セッター
     * 
     * @param deleted
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
