package com.keita.nakamura.entity;

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
    private String companyName;

    /**
     * 代表者名
     */
    private String representativeName;

    /**
     * 電話番号
     */
    private String phoneNumber;

    /**
     * 郵便番号
     */
    private String postalCode;

    /**
     * 都道府県コード
     */
    private String prefectureCode;

    /**
     * 住所
     */
    private String address;

    /**
     * メールアドレス
     */
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
     * 
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 
     * @return
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 
     * @return
     */
    public String getRepresentativeName() {
        return representativeName;
    }

    /**
     * 
     * @param representativeName
     */
    public void setRepresentativeName(String representativeName) {
        this.representativeName = representativeName;
    }

    /**
     * 
     * @return
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 
     * @return
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 
     * @return
     */
    public String getPrefectureCode() {
        return prefectureCode;
    }

    /**
     * 
     * @param prefectureCode
     */
    public void setPrefectureCode(String prefectureCode) {
        this.prefectureCode = prefectureCode;
    }

    /**
     * 
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 
     * @return
     */
    public String getMailAddress() {
        return mailAddress;
    }

    /**
     * 
     * @param mailAddress
     */
    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    /**
     * 
     * @return
     */
    public String getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     */
    public void setCreated(String created) {
        this.created = created;
    }

    /**
     * 
     * @return
     */
    public String getModified() {
        return modified;
    }

    /**
     * 
     * @param modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     * 
     * @return
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * 
     * @param deleted
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
