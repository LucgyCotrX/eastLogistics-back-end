package com.east.logistics.service.impl;

import com.east.logistics.dao.WaybillMapper;
import com.east.logistics.entity.Waybill;
import com.east.logistics.service.WaybillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WaybillServiceImpl implements WaybillService {

    @Autowired
    private WaybillMapper waybillMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return waybillMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param waybill
     * @return
     */
    @Override
    public int insert(Waybill waybill) {
        return waybillMapper.insert(waybill);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Waybill selectByPrimaryKey(Integer id) {
        return waybillMapper.selectByPrimaryKey(id);
    }



    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Waybill> selectAll() {
        return waybillMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param waybill
     * @return
     */
    @Override
    public int updateByPrimaryKey(Waybill waybill) {
        return waybillMapper.updateByPrimaryKey(waybill);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return waybillMapper.count();
    }

    @Override
    public List<Waybill> selectStart(String wStatus, Integer wId, Integer cid, String wSphone,Integer wIntime,Integer wOuttime,Double wPrice,String wSaddress,String wRaddress,String wRphone,Integer sInid,Integer sOutid) {
        return waybillMapper.selectStart(wStatus,wId,cid,wSphone,wIntime,wOuttime,wPrice,wSaddress,wRaddress,wRphone,sInid,sOutid);
    }

    @Override
    public int countStart(String wStatus, Integer wId, Integer cid, String wSphone,Integer wIntime,Integer wOuttime,Double wPrice,String wSaddress,String wRaddress,String wRphone,Integer sInid,Integer sOutid) {
        return waybillMapper.countStart(wStatus,wId,cid,wSphone,wIntime,wOuttime,wPrice,wSaddress,wRaddress,wRphone,sInid,sOutid);
    }

    @Override
    public int countType(String wIntype, Integer cId, Integer sInid) {
        return waybillMapper.countType(wIntype,cId,sInid);
    }


    @Override
    public int updateSet(Integer wId, String wStatus, Integer wOuttime) {
        return waybillMapper.updateSet(wId,wStatus,wOuttime);
    }
}
