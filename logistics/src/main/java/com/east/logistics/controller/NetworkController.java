package com.east.logistics.controller;

import com.east.logistics.dao.NetworkMapper;
import com.east.logistics.entity.Network;
import com.east.logistics.service.NetworkService;
import com.east.logistics.util.Result;
import com.github.pagehelper.PageHelper;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is Description
 *
 * @author logan
 * @date 2019/09/03
 */
@RestController
@RequestMapping("/network")
public class NetworkController {


        @Autowired
        private NetworkService networkService;
        @Autowired
        private NetworkMapper networkMapper;

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

                return networkService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
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
        public Result insert(@RequestBody Network network) {
            try {
                return networkService.insert(network) > 0 ? new Result().successMessage("添加成功！") : Result.error("添加失败！");
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
                Network network1 = networkService.selectByPrimaryKey(id);
                if (network1 == null) {
                    return new Result().successMessage("无数据");
                } else {
                    return new Result().success(network1);
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
                List<Network> list = networkService.selectAll();
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
        public Result updateByPrimaryKey(@RequestBody Network network) {
            try {
                return networkService.updateByPrimaryKey(network) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
                List<Network> list = networkService.selectAll();
                if (list == null) {
                    return new Result().successMessage("无数据");
                } else {
                    return new Result(0, "ok", list, networkService.count());
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
        public Result selectVague(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit, String nProvince, String nCity, String nCounty, String nAddress, Integer nIn, Integer nOut) {
            try {
                PageHelper.startPage(page, limit);
                List<Network> list = networkService.selectVague(nProvince, nCity, nCounty, nAddress, nIn, nOut);
                if (list == null) {
                    return new Result().successMessage("无数据");
                } else {
                    return new Result(0, "ok", list, networkService.countVague(nProvince, nCity, nCounty, nAddress, nIn, nOut));
                }
            } catch (Exception ex) {
                return new Result().error(ex.getMessage());
            }
        }


    }


