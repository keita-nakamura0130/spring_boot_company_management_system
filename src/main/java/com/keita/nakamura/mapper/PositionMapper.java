package com.keita.nakamura.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.Position;

/**
 * Positionマッパー
 */
@Mapper
public interface PositionMapper {
    /**
     *  役職一覧を取得
     */
    List<Position> findAll();

    /**
     * IDより役職を1件取得
     *
     * @param id
     */
    Position findById(int id);

    /**
     * 役職を追加
     *
     * @param Positon
     */
    void insert(Position Positon);

    /**
     * 役職を編集
     *
     * @param Positon
     */
    void update(Position Positon);

    /**
     * 役職を削除
     *
     * @param id
     */
    void delete(int id);
}
