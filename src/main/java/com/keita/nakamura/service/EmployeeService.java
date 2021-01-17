package com.keita.nakamura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.Employee;
import com.keita.nakamura.mapper.EmployeeMapper;

/**
 * Employeeサービス
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper EmployeeMapper;

    /**
     * 社員一覧を取得
     *
     * @return
     */
    public List<Employee> findAll(int companyId) {
        return EmployeeMapper.findAll(companyId);
    }

    /**
     * IDより社員を1件取得
     *
     * @param id
     * @return
     */
    public Employee findById(int id) {
        return EmployeeMapper.findById(id);
    }

    /**
     * 社員を追加
     *
     * @param Employee
     */
    public void insert(Employee Employee) {
        EmployeeMapper.insert(Employee);
    }

    /**
     * 社員を編集
     *
     * @param Employee
     */
    public void update(Employee Employee) {
        EmployeeMapper.update(Employee);
    }

    /**
     * 社員を削除
     *
     * @param id
     */
    public void delete(int id) {
        EmployeeMapper.delete(id);
    }
}
