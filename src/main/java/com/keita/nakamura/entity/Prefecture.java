package com.keita.nakamura.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Prefectureクラス
 */
@Getter
@Setter
public class Prefecture {
    /**
     * ID
     */
    private int id;
    
    /**
     * 都道府県名
     */
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
