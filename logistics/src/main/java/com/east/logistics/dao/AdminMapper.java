package com.east.logistics.dao;

import com.east.logistics.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
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
     * 根据主键全部修改操作
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
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    Admin yzm(@Param("phone") String phone);
    //修改密码
    int updatePassword(@Param("password") String password, @Param("aId") int aId);
    /**
     * 根据手机号码获取信息
     * @param phone
     * @return
     */
    Admin yzms(@Param("phone") String phone);

}