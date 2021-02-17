package com.keita.nakamura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.Company;
import com.keita.nakamura.mapper.CompanyMapper;

/**
 * Companyサービス
 */
@Service
public class CompanyService {
    @Autowired
    CompanyMapper CompanyMapper;

    /**
     * 会社一覧を取得
     *
     * @return
     */
    public List<Company> findAll() {
        return CompanyMapper.findAll();
    }

    /**
     * 検索より会社一覧を取得
     *
     * @param name
     * @param representative
     * @param prefectureCode
     * @return
     */
    public List<Company> findBySearch(String name, String representative, String prefectureCode) {
        return CompanyMapper.findBySearch(name, representative, prefectureCode);
    }

    /**
     * IDより会社を1件取得
     *
     * @param id
     * @return
     */
    public Company findById(int id) {
        return CompanyMapper.findById(id);
    }

    /**
     * 会社を追加
     *
     * @param company
     */
    public void insert(Company company) {
        CompanyMapper.insert(company);
    }

    /**
     * 会社をバルクインサート
     *
     * @param companies
     */
    public void bulkInsert(List<Company> companies) {
        CompanyMapper.bulkInsert(companies);
    }

    /**
     * 会社を編集
     *
     * @param company
     */
    public void update(Company company) {
        CompanyMapper.update(company);
    }

    /**
     * 会社を削除
     *
     * @param id
     */
    public void delete(int id) {
        CompanyMapper.delete(id);
    }
}
