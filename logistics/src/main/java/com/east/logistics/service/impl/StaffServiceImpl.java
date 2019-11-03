package com.east.logistics.service.impl;

import com.east.logistics.dao.StaffMapper;
import com.east.logistics.entity.Staff;
import com.east.logistics.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return staffMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param staff
     * @return
     */
    @Override
    public int insert(Staff staff) {
        return staffMapper.insert(staff);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Staff selectByPrimaryKey(int id) {
        return staffMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Staff> selectAll() {
        return staffMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param staff
     * @return
     */
    @Override
    public int updateByPrimaryKey(Staff staff) {
        return staffMapper.updateByPrimaryKey(staff);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return staffMapper.count();
    }

    @Override
    public List<Staff> selectVague(String dName,String dPhone,String dSex, String dAccount, String dPassword,Integer nId,Integer dIn,Integer dOut) {
        return staffMapper.selectVague(dName,dPhone,dSex,dAccount,dPassword,nId,dIn,dOut);
    }

    @Override
    public int countVague(String dName,String dPhone,String dSex, String dAccount, String dPassword,Integer nId,Integer dIn,Integer dOut) {
        return staffMapper.countVague(dName,dPhone,dSex,dAccount,dPassword,nId,dIn,dOut);
    }
}
