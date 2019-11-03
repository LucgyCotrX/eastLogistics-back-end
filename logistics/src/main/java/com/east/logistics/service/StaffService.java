package com.east.logistics.service;

import com.east.logistics.entity.Staff;

import java.util.List;

public interface StaffService {

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
     * @param staff
     * @return
     */
    int insert(Staff staff);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Staff selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Staff> selectAll();

    /**
     * 修改操作
     *
     * @param staff
     * @return
     */
    int updateByPrimaryKey(Staff staff);

    /**
     * 查询所有数据
     * @return
     */
    int count();

    List<Staff> selectVague(String dName,String dPhone,String dSex, String dAccount, String dPassword,Integer nId,Integer dIn,Integer dOut);

    int countVague(String dName,String dPhone,String dSex, String dAccount, String dPassword,Integer nId,Integer dIn,Integer dOut);
}