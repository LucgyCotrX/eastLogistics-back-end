 
package com.east.logistics.controller;

import com.east.logistics.dao.CustomerMapper;
import com.east.logistics.entity.Customer;
import com.east.logistics.service.CustomerService;
import com.east.logistics.util.Result;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerMapper customerMapper;

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

            return customerService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
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
    public Result insert(@RequestBody Customer customer) {
        try {
            return customerService.insert(customer) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
            Customer customer1 = customerService.selectByPrimaryKey(id);
            if (customer1 == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result().success(customer1);
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
            List<Customer> list = customerService.selectAll();
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
    public Result updateByPrimaryKey(@RequestBody Customer customer) {
        try {
            return customerService.updateByPrimaryKey(customer) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
            List<Customer> list = customerService.selectAll();
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, customerService.count());
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
    public Result selectVague(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit, String cName, String cJob, String cAddress, String cPhone, Integer sId, Integer cBillnums, Integer tId, Integer cSend) {
        try {
            PageHelper.startPage(page, limit);
            List<Customer> list = customerService.selectVague(cName, cJob, cAddress, cPhone,sId, cBillnums, tId, cSend);
            if (list == null) {
                return new Result().successMessage("无数据");
            } else {
                return new Result(0, "ok", list, customerService.countVague(cName, cJob, cAddress, cPhone,sId, cBillnums, tId, cSend));
            }
        } catch (Exception ex) {
            return new Result().error(ex.getMessage());
        }
    }

   
}
