package com.east.logistics.dao;

import com.east.logistics.entity.Locations;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationsMapper {
    /**
     * 根据主键删除操作
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
    int updateType(@Param("id") int id,@Param("type") int type);
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
     * 根据主键全部修改操作
     *
     * @param locations
     * @return
     */
    int updateByPrimaryKey(Locations locations);

}