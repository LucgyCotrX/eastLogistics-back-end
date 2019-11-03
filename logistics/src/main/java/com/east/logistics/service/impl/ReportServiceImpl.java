package com.east.logistics.service.impl;

import com.east.logistics.dao.ReportMapper;
import com.east.logistics.entity.Report;
import com.east.logistics.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    /**
     * 删除操作 根据主键删除
     *
     * @param id
     * @return
     */
    @Override
    public int deleteByPrimaryKey(int id) {
        return reportMapper.deleteByPrimaryKey(id);
    }

    /**
     * 添加操作
     *
     * @param report
     * @return
     */
    @Override
    public int insert(Report report) {
        return reportMapper.insert(report);
    }

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    @Override
    public Report selectByPrimaryKey(int id) {
        return reportMapper.selectByPrimaryKey(id);
    }

    /**
     * 全部查询操作
     *
     * @return
     */
    @Override
    public List<Report> selectAll() {
        return reportMapper.selectAll();
    }

    /**
     * 修改操作
     *
     * @param report
     * @return
     */
    @Override
    public int updateByPrimaryKey(Report report) {
        return reportMapper.updateByPrimaryKey(report);
    }

    /**
     * 查询所有数据
     * @return
     */
    @Override
    public int count() {
        return reportMapper.count();
    }

    @Override
    public List<Report> selectVague(String rName, Integer sId, Integer cId, String rStatisticstime, Timestamp rCreatetime, String rStatus) {
        return reportMapper.selectVague(rName, sId, cId, rStatisticstime, rCreatetime, rStatus);
    }

    @Override
    public int countVague(String rName, Integer sId, Integer cId, String rStatisticstime, Timestamp rCreatetime, String rStatus) {
        return reportMapper.countVague(rName, sId, cId, rStatisticstime, rCreatetime, rStatus);
    }
}
