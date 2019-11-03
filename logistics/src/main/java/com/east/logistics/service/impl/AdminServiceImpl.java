package com.east.logistics.service.impl;

import com.east.logistics.dao.AdminMapper;
import com.east.logistics.entity.Admin;
import com.east.logistics.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param admin
     * @return
     */
    @Override
    public int insert(Admin admin) {
        return adminMapper.insert(admin);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Admin selectByPrimaryKey(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Admin> selectAll() {
        return adminMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param admin
     * @return
     */
    @Override
    public int updateByPrimaryKey(Admin admin) {
        return adminMapper.updateByPrimaryKey(admin);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return adminMapper.count();
    }
}
