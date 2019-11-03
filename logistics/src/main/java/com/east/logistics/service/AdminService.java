package com.east.logistics.service;

import com.east.logistics.entity.Admin;

import java.util.List;

public interface AdminService {

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
     * @param admin
     * @return
     */
    int insert(Admin admin);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Admin selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Admin> selectAll();

    /**
     * 修改操作
     *
     * @param admin
     * @return
     */
    int updateByPrimaryKey(Admin admin);

    /**
     * 查询所有数据
     * @return
     */
    int count();
}