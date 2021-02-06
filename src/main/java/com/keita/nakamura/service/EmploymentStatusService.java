package com.keita.nakamura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.EmploymentStatus;
import com.keita.nakamura.mapper.EmploymentStatusMapper;

/**
 * EmploymentStatusサービス
 */
@Service
public class EmploymentStatusService {
    @Autowired
    EmploymentStatusMapper EmploymentStatusMapper;

    /**
     * 雇用形態一覧を取得
     *
     * @return
     */
    public List<EmploymentStatus> findAll() {
        return EmploymentStatusMapper.findAll();
    }

    /**
     * IDより雇用形態を1件取得
     *
     * @param id
     * @return
     */
    public EmploymentStatus findById(int id) {
        return EmploymentStatusMapper.findById(id);
    }

    /**
     * 雇用形態を追加
     *
     * @param EmploymentStatus
     */
    public void insert(EmploymentStatus EmploymentStatus) {
        EmploymentStatusMapper.insert(EmploymentStatus);
    }

    /**
     * 雇用形態を編集
     *
     * @param EmploymentStatus
     */
    public void update(EmploymentStatus EmploymentStatus) {
        EmploymentStatusMapper.update(EmploymentStatus);
    }

    /**
     * 雇用形態を削除
     *
     * @param id
     */
    public void delete(int id) {
        EmploymentStatusMapper.delete(id);
    }
}
