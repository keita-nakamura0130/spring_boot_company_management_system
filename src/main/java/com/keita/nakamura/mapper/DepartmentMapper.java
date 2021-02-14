package com.keita.nakamura.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.Department;

/**
 * Departmentマッパー
 */
@Mapper
public interface DepartmentMapper {
    /**
     *  部署一覧を取得
     */
    List<Department> findAll();

    /**
     * IDより部署を1件取得
     *
     * @param id
     */
    Department findById(int id);

    /**
     * 部署を追加
     *
     * @param Department
     */
    void insert(Department Department);

    /**
     * 部署を編集
     *
     * @param Department
     */
    void update(Department Department);

    /**
     * 部署を削除
     *
     * @param id
     */
    void delete(int id);
}
