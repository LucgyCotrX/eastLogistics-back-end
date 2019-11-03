package com.east.logistics.service.impl;

import com.east.logistics.dao.CustomerMapper;
import com.east.logistics.entity.Customer;
import com.east.logistics.service.CustomerService;
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
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param customer
     * @return
     */
    @Override
    public int insert(Customer customer) {
        return customerMapper.insert(customer);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Customer selectByPrimaryKey(int id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Customer> selectAll() {
        return customerMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param customer
     * @return
     */
    @Override
    public int updateByPrimaryKey(Customer customer) {
        return customerMapper.updateByPrimaryKey(customer);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return customerMapper.count();
    }

    @Override
    public List<Customer> selectVague(String cName, String cJob, String cAddress, String cPhone, Integer sId, Integer cBillnums, Integer tId, Integer cSend) {
        return customerMapper.selectVague(cName, cJob, cAddress, cPhone, sId, cBillnums, tId, cSend);
    }

    @Override
    public int countVague(String cName, String cJob, String cAddress, String cPhone, Integer sId, Integer cBillnums, Integer tId, Integer cSend) {
        return customerMapper.countVague(cName, cJob, cAddress, cPhone, sId, cBillnums, tId, cSend);
    }

}
