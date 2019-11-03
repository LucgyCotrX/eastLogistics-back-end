
package com.east.logistics.service;

import com.east.logistics.entity.Report;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public interface ReportService {

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
     * @param report
     * @return
     */
    int insert(Report report);

    /**
     * 根据主键查询操作
     *
     * @param id
     * @return
     */
    Report selectByPrimaryKey(int id);

    /**
     * 全部查询操作
     *
     * @return
     */
    List<Report> selectAll();

    /**
     * 修改操作
     *
     * @param report
     * @return
     */
    int updateByPrimaryKey(Report report);

    /**
     * 查询所有数据
     * @return
     */
    int count();

    List<Report> selectVague(String rName, Integer sId, Integer cId, String rStatisticstime, Timestamp rCreatetime, String rStatus);

    int countVague(String rName, Integer sId, Integer cId, String rStatisticstime, Timestamp rCreatetime, String rStatus);
}