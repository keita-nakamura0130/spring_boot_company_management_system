package com.keita.nakamura.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.Employee;

/**
 * Employeeマッパー
 */
@Mapper
public interface EmployeeMapper {
    /**
     * 社員一覧を取得
     *
     * @param CompanyId
     * @return
     */
    List<Employee> findAll(int CompanyId);

    /**
     * IDより社員を1件取得
     *
     * @param id
     */
    Employee findById(int id);

    /**
     * 社員を追加
     *
     * @param Employee
     */
    void insert(Employee Employee);

    /**
     * 社員を編集
     *
     * @param Employee
     */
    void update(Employee Employee);

    /**
     * 社員を削除
     *
     * @param id
     */
    void delete(int id);
}
