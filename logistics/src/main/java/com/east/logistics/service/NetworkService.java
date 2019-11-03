package com.east.logistics.service;

import com.east.logistics.entity.Network;
import com.east.logistics.util.Result;

import java.util.List;

/**
 * This is Description
 *
 * @author logan
 * @date 2019/09/03
 */
public interface NetworkService {
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
     * @param network
     * @return
     */
    int insert(Network network);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Network selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Network> selectAll();

    /**
     * 修改操作
     *
     * @param network
     * @return
     */
    int updateByPrimaryKey(Network network);

    /**
     * 查询所有数据
     * @return
     */
    int count();

    List<Network> selectVague(String nProvince,String nCity,String nCounty,String nAddress,Integer nIn,Integer nOut  );

    int countVague(String nProvince,String nCity,String nCounty,String nAddress,Integer nIn,Integer nOut  );
}
