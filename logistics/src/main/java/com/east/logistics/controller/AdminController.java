package com.east.logistics.controller;
import com.east.logistics.dao.AdminMapper;
import com.east.logistics.entity.Admin;
import com.east.logistics.service.AdminService;
import com.east.logistics.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper adminMapper;
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
            return adminService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

    /**
     * 添加对象admin
     *
     * @param admin
     * @return
     */
    @PostMapping("/insert")
    public Result insert(@RequestBody Admin admin) {
        try {
            return adminService.insert(admin) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            Admin admin1 = adminService.selectByPrimaryKey(id);
            if (admin1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(admin1);
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
            List<Admin> list = adminService.selectAll();
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
     * @param admin
     * @return
     */
    @PostMapping(value = "/updateByPrimaryKey")
    public Result updateByPrimaryKey(@RequestBody Admin admin) {
        try {
            return adminService.updateByPrimaryKey(admin) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<Admin> list = adminService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, adminService.count());
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
    public Result updatePassword(String password,String old, int id) {
        try {
            Admin admin = adminService.selectByPrimaryKey(id);
            if(admin != null){
                if(admin.getaPassword().equals(old)){
                    if(adminMapper.updatePassword(password,id)>0)
                        return new Result(200,"修改成功！");
                }
            }
            return new Result().error("修改失败!");
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }
}
