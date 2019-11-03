package com.east.logistics.service;

import com.east.logistics.entity.Locations;

import java.util.List;

public interface LocationsService {

    /**
     * 删除操作 根据主键
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(int id);

    /**
     * 添加操作
     *
     * @param locations
     * @return
     */
    int insert(Locations locations);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Locations selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Locations> selectAll();

    /**
     * 修改操作
     *
     * @param locations
     * @return
     */
    int updateByPrimaryKey(Locations locations);


}