package com.keita.nakamura.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keita.nakamura.entity.Position;
import com.keita.nakamura.mapper.PositionMapper;

/**
 * Positionサービス
 */
@Service
public class PositionService {
    @Autowired
    PositionMapper PositionMapper;

    /**
     * 役職一覧を取得
     *
     * @return
     */
    public List<Position> findAll() {
        return PositionMapper.findAll();
    }

    /**
     * 役職を追加
     *
     * @param Position
     */
    public void insert(Position Position) {
        PositionMapper.insert(Position);
    }

    /**
     * 役職を編集
     *
     * @param Position
     */
    public void update(Position Position) {
        PositionMapper.update(Position);
    }

    /**
     * 役職を削除
     *
     * @param id
     */
    public void delete(int id) {
        PositionMapper.delete(id);
    }
}
