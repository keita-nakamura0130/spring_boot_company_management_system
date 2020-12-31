package com.keita.nakamura.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.keita.nakamura.entity.Company;

@Mapper
public interface CompanyMapper {
    List<Company> findAll();
}
