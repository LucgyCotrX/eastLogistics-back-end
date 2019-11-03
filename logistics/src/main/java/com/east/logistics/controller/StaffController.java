package com.east.logistics.controller;

import com.east.logistics.dao.StaffMapper;
import com.east.logistics.entity.Staff;
import com.east.logistics.service.StaffService;
import com.east.logistics.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @Autowired
    private StaffService staffService;
    @Autowired
    private StaffMapper staffMapper;

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

            return staffService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
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
    public Result insert(@RequestBody Staff staff) {
        try {
            return staffService.insert(staff) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            Staff staff1 = staffService.selectByPrimaryKey(id);
            if (staff1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(staff1);
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
            List<Staff> list = staffService.selectAll();
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
    public Result updateByPrimaryKey(@RequestBody Staff staff) {
        try {
            return staffService.updateByPrimaryKey(staff) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<Staff> list = staffService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, staffService.count());
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
    public Result selectVague(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit, String dName, String dPhone, String dSex, String dAccount, String dPassword, Integer nId, Integer dIn, Integer dOut) {
        try {
            PageHelper.startPage(page, limit);
            List<Staff> list = staffService.selectVague(dName, dPhone, dSex, dAccount, dPassword, nId, dIn, dOut);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, staffService.countVague(dName, dPhone, dSex, dAccount, dPassword, nId, dIn, dOut));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /* 修改密码
     *
     * @return
     */
    @GetMapping("/updatePassword")
    public Result updatePassword(String password, String old, int id) {
        try {
            Staff staff = staffService.selectByPrimaryKey(id);
            if (staff != null) {
                if (staff.getsPassword().equals(old)) {
                    if (staffMapper.updatePassword(password, id) > 0)
                        return new Result(200, "修改成功！");
                }
            }
            return new Result().error("修改失败!");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
