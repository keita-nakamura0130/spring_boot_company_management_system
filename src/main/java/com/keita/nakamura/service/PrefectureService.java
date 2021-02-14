package com.keita.nakamura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.Prefecture;
import com.keita.nakamura.mapper.PrefectureMapper;

/**
 * Prefectureサービス
 */
@Service
public class PrefectureService {
    @Autowired
    PrefectureMapper prefectureMapper;

    /**
     * 都道府県一覧を取得
     *
     * @return
     */
    public List<Prefecture> findAll() {
        return prefectureMapper.findAll();
    }

    /**
     * IDより都道府県を1件取得
     *
     * @param id
     * @return
     */
    public Prefecture findById(int id) {
        return prefectureMapper.findById(id);
    }
}
