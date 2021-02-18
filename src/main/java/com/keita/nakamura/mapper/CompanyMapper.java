package com.keita.nakamura.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.Company;

/**
 * Companyマッパー
 */
@Mapper
public interface CompanyMapper {
    /**
     *  会社一覧を取得
     */
    List<Company> findAll();

    /**
     * 検索より会社一覧を取得
     *
     * @param name
     * @param representative
     * @param prefectureCode
     * @return
     */
    List<Company> findBySearch(String name, String representative, String prefectureId);

    /**
     * IDより会社を1件取得
     *
     * @param id
     */
    Company findById(int id);

    /**
     * 会社を追加
     *
     * @param company
     */
    void insert(Company company);

    /**
     * 会社をバルクインサート
     *
     * @param company
     * @return
     */
    void bulkInsert(List<Company> companies);

    /**
     * 会社を編集
     *
     * @param company
     */
    void update(Company company);

    /**
     * 会社を削除
     *
     * @param id
     */
    void delete(int id);
}
