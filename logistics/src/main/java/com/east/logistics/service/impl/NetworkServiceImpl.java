package com.east.logistics.service.impl;

import com.east.logistics.dao.NetworkMapper;
import com.east.logistics.entity.Network;
import com.east.logistics.service.NetworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This is Description
 *
 * @author logan
 * @date 2019/09/03
 */
@Service
public class NetworkServiceImpl implements NetworkService {
    @Autowired
    private NetworkMapper networkMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return networkMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param network
     * @return
     */
    @Override
    public int insert(Network network) {
        return networkMapper.insert(network);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Network selectByPrimaryKey(int id) {
        return networkMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Network> selectAll() {
        return networkMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param network
     * @return
     */
    @Override
    public int updateByPrimaryKey(Network network) {
        return networkMapper.updateByPrimaryKey(network);
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @Override
    public int count() {
        return networkMapper.count();
    }

    @Override
    public List<Network> selectVague(String nProvince, String nCity, String nCounty, String nAddress, Integer nIn, Integer nOut) {
        return networkMapper.selectVague(nProvince, nCity, nCounty, nAddress, nIn, nOut);
    }

    @Override
    public int countVague(String nProvince, String nCity, String nCounty, String nAddress, Integer nIn, Integer nOut) {
        return networkMapper.countVague(nProvince, nCity, nCounty, nAddress, nIn, nOut);
    }
}
