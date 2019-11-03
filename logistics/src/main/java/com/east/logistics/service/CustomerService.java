package com.east.logistics.service;

import com.east.logistics.entity.Customer;
import com.east.logistics.util.Result;

import java.util.List;

/**
 * This is Description
 *
 * @author logan
 * @date 2019/09/03
 */
public interface CustomerService {


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
    int insert(Customer staff);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Customer selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Customer> selectAll();

    /**
     * 修改操作
     *
     * @param staff
     * @return
     */
    int updateByPrimaryKey(Customer staff);

    /**
     * 查询所有数据
     * @return
     */
    int count();

    List<Customer> selectVague(String cName, String cJob, String cAddress, String cPhone, Integer sId, Integer cBillnums, Integer tId, Integer cSend);

    int countVague(String cName, String cJob, String cAddress, String cPhone, Integer sId, Integer cBillnums, Integer tId, Integer cSend);
}
