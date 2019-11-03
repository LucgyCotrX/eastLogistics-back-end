 
 
package com.east.logistics.controller;

import com.east.logistics.dao.ReportMapper;
import com.east.logistics.entity.Report;
import com.east.logistics.service.ReportService;
import com.east.logistics.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    @Autowired
    private ReportMapper reportMapper;

    /**
     * 根据主键删除
     * 要求转入 aId
     *
     * @param id
     * @return
     */
    @GetMapping("/deleteByPrimaryKey")
    public Result deleteByPrimaryKey(int id) {
        try {

            return reportService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象Staff
     *
     * @param
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Report report) {
        try {
            return reportService.insert(report) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }

    }

    /**
     * 根据主键查找对象  最多只能返回一个对象
     *
     * @param id
     * @return
     */
    @GetMapping("/selectByPrimaryKey")
    public Result selectByPrimaryKey(int id) {
        try {
            Report report1 = reportService.selectByPrimaryKey(id);
            if (report1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(report1);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 查询所有数据
     *
     * @return
     */
    @GetMapping("/selectAll")
    public Result selectAll() {
        try {
            List<Report> list = reportService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(list);
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 根据主键修改全部字段
     *
     * @param
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody Report report) {
        try {
            return reportService.updateByPrimaryKey(report) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }


    /* 查询所有数据分页
     *
     * @return
     */
    @GetMapping("/selectPage")
    public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit) {
        try {
            PageHelper.startPage(page, limit);
            List<Report> list = reportService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, reportService.count());
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /* 模糊查询
     *
     * @return
     */
    @GetMapping("/selectVague")
    public Result selectVague(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit, String rName, Integer sId, Integer cId, String rStatisticstime, Timestamp rCreatetime, String rStatus) {
        try {
            PageHelper.startPage(page, limit);
            List<Report> list = reportService.selectVague(rName,sId,cId,rStatisticstime,rCreatetime,rStatus);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, reportService.countVague(rName,sId,cId,rStatisticstime,rCreatetime,rStatus));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

   
}
