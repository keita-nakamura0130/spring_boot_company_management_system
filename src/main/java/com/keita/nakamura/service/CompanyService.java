package com.keita.nakamura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.keita.nakamura.entity.Company;
import com.keita.nakamura.mapper.CompanyMapper;
import com.keita.nakamura.mapper.EmployeeMapper;

/**
 * Companyサービス
 */
@Service
public class CompanyService {

    /**
     * Companyマッパー
     */
    @Autowired
    CompanyMapper companyMapper;

    /**
     * Employeeマッパー
     */
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * 会社一覧を取得
     *
     * @return
     */
    @Transactional
    public List<Company> findAll() {
        return companyMapper.findAll();
    }

    /**
     * 検索より会社一覧を取得
     *
     * @param name
     * @param representative
     * @param prefectureCode
     * @return
     */
    @Transactional
    public List<Company> findBySearch(String name, String representative, String prefectureId) {
        return companyMapper.findBySearch(name, representative, prefectureId);
    }

    /**
     * IDより会社を1件取得
     *
     * @param id
     * @return
     */
    @Transactional
    public Company findById(int id) {
        return companyMapper.findById(id);
    }

    /**
     * 会社を追加
     *
     * @param company
     */
    @Transactional
    public void insert(Company company) {
        companyMapper.insert(company);
    }

    /**
     * 会社をバルクインサート
     *
     * @param companies
     */
    @Transactional
    public void bulkInsert(List<Company> companies) {
        companyMapper.bulkInsert(companies);
    }

    /**
     * 会社を編集
     *
     * @param company
     */
    @Transactional
    public void update(Company company) {
        companyMapper.update(company);
    }

    /**
     * 会社を削除
     *
     * @param id
     */
    @Transactional
    public void delete(int id) {
        companyMapper.delete(id);

        // 会社に紐付く社員も削除
        employeeMapper.deleteByCompanyId(id);
    }
}
