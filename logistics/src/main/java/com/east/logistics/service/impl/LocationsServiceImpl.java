package com.east.logistics.service.impl;

import com.east.logistics.dao.LocationsMapper;
import com.east.logistics.entity.Locations;
import com.east.logistics.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationsServiceImpl implements LocationsService {

    @Autowired
    private LocationsMapper locationsMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return locationsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param locations
     * @return
     */
    @Override
    public int insert(Locations locations) {
        return locationsMapper.insert(locations);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Locations selectByPrimaryKey(int id) {
        return locationsMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Locations> selectAll() {
        return locationsMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param locations
     * @return
     */
    @Override
    public int updateByPrimaryKey(Locations locations) {
        return locationsMapper.updateByPrimaryKey(locations);
    }


}
