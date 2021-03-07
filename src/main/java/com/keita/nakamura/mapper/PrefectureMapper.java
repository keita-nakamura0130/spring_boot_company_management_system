package com.keita.nakamura.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.Prefecture;

/**
 * Prefectureマッパー
 */
@Mapper
public interface PrefectureMapper {
    /**
     *  都道府県一覧を取得
     */
    List<Prefecture> findAll();

    /**
     * IDより都道府県を1件取得
     *
     * @param id
     */
    Prefecture findById(int id);
}
