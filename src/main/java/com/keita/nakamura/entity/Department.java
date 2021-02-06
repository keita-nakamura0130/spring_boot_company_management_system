package com.keita.nakamura.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * Departmentクラス
 */
@Getter
@Setter
public class Department {
    /**
     * ID
     */
    private int id;
    
    /**
     * 役職名
     */
    @NotBlank(message = "必須入力です")
    @Size(max = 20, message="20文字以内で入力してください")
    private String name;
    
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
