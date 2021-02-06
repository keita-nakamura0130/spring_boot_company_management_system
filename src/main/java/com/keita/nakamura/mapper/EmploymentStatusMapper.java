package com.keita.nakamura.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.EmploymentStatus;

/**
 * EmploymentStatusマッパー
 */
@Mapper
public interface EmploymentStatusMapper {
    /**
     *  雇用形態一覧を取得
     */
    List<EmploymentStatus> findAll();

    /**
     * 雇用形態を追加
     *
     * @param EmploymentStatus
     */
    void insert(EmploymentStatus EmploymentStatus);

    /**
     * 雇用形態を編集
     *
     * @param EmploymentStatus
     */
    void update(EmploymentStatus EmploymentStatus);

    /**
     * 雇用形態を削除
     *
     * @param id
     */
    void delete(int id);
}
