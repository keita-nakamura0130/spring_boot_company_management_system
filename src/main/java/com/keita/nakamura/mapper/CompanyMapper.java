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
}
