package com.east.logistics.service;

import com.east.logistics.entity.Waybill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WaybillService {

    /**
     * 删除操作 根据主键
     *
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加操作
     *
     * @param waybill
     * @return
     */
    int insert(Waybill waybill);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Waybill selectByPrimaryKey(Integer id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Waybill> selectAll();

    /**
     * 修改操作
     *
     * @param waybill
     * @return
     */
    int updateByPrimaryKey(Waybill waybill);

    /**
     * 查询所有数据
     * @return
     */
    int count();

    //根据订单状态查询
    List<Waybill> selectStart(String wStatus, Integer wId, Integer cid, String wSphone,Integer wIntime,Integer wOuttime,Double wPrice,String wSaddress,String wRaddress,String wRphone,Integer sInid,Integer sOutid);

    int countStart(String wStatus, Integer wId, Integer cid, String wSphone,Integer wIntime,Integer wOuttime,Double wPrice,String wSaddress,String wRaddress,String wRphone,Integer sInid,Integer sOutid);
    int countType(String wIntype, Integer cId,Integer sInid);
    //订单号、订单状态、完成时间
    int updateSet(@Param("wId") Integer wId,@Param("wStatus") String wStatus,@Param("wOuttime") Integer wOuttime);
}