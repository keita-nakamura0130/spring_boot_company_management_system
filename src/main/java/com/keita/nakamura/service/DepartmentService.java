package com.keita.nakamura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.Department;
import com.keita.nakamura.mapper.DepartmentMapper;

/**
 * Departmentサービス
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper DepartmentMapper;

    /**
     * 部署一覧を取得
     *
     * @return
     */
    public List<Department> findAll() {
        return DepartmentMapper.findAll();
    }

    /**
     * 部署を追加
     *
     * @param Department
     */
    public void insert(Department Department) {
        DepartmentMapper.insert(Department);
    }

    /**
     * 部署を編集
     *
     * @param Department
     */
    public void update(Department Department) {
        DepartmentMapper.update(Department);
    }

    /**
     * 部署を削除
     *
     * @param id
     */
    public void delete(int id) {
        DepartmentMapper.delete(id);
    }
}
