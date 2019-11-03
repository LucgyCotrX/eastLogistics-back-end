package com.east.logistics.controller;

import com.east.logistics.dao.WaybillMapper;
import com.east.logistics.entity.Waybill;
import com.east.logistics.service.WaybillService;
import com.east.logistics.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.github.pagehelper.PageHelper;
/**
 * This is Description
 *
 * @author logan
 * @date 2019/09/02
 */
@RestController
@RequestMapping("/waybill")
public class WaybillController {

        @Autowired
        private WaybillService waybillService;

        @Autowired
        private WaybillMapper waybillMapper;
        /**
         * 根据主键删除
         * 要求转入 aId
         *
         * @param id
         * @return
         */
        @GetMapping("/deleteByPrimaryKey")
        public Result deleteByPrimaryKey(Integer id) {
            try {
                return waybillService.deleteByPrimaryKey(id) > 0 ? new Result().successMessage("删除成功") : Result.error("删除失败");
            } catch (Exception ex) {
                return new Result().error(ex.getMessage());
            }
        }

        /**
         * 添加对象waybill
         *
         * @param waybill
         * @return
         */
        @PostMapping("/insert")
        public Result insert(@RequestBody Waybill waybill) {
            try {
//                waybill.setwId(String.valueOf(System.currentTimeMillis()));
                return waybillService.insert(waybill) > 0 ? new Result().successMessage("添加成功!"): Result.error("添加失败！");
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
        public Result selectByPrimaryKey(Integer id) {
            try {
                Waybill waybill1 = waybillService.selectByPrimaryKey(id);
                if (waybill1 == null) {
                    return new Result().successMessage("无数据");
                } else {
                    return new Result().success(waybill1);
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
                List<Waybill> list = waybillService.selectAll();
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
         * @param waybill
         * @return
         */
        @PostMapping(value = "/updateByPrimaryKey")
        public Result updateByPrimaryKey(@RequestBody Waybill waybill) {
            try {
                return waybillService.updateByPrimaryKey(waybill) > 0 ? new Result().successMessage("修改成功") : Result.error("修改失败");
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
                List<Waybill> list = waybillService.selectAll();
                if (list == null) {
                    return new Result().successMessage("无数据");
                } else {
                    return new Result(0, "ok", list, waybillService.count());
                }
            } catch (Exception ex) {
                return new Result().error(ex.getMessage());
            }
        }

        /* 根据订单状态进行查询
         *
         * @return
         */
        @GetMapping("/selectStart")
        public Result selectPage(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit,String wStatus, @RequestParam(defaultValue = "0") Integer wId,@RequestParam(defaultValue = "0")   Integer cid, String wSphone,Integer wIntime,Integer wOuttime,@RequestParam(defaultValue = "0")  Double wPrice,String wSaddress,String wRaddress,String wRphone,@RequestParam(defaultValue = "0")  Integer sInid,@RequestParam(defaultValue = "0")  Integer sOutid) {
            try {
                PageHelper.startPage(page, limit);
                List<Waybill> list = waybillService.selectStart(wStatus,wId,cid,wSphone,wIntime,wOuttime,wPrice,wSaddress,wRaddress,wRphone,sInid,sOutid);
                if (list == null) {
                    return new Result().successMessage("无数据");
                } else {
                    return new Result(0, "ok", list, waybillService.countStart(wStatus,wId,cid,wSphone,wIntime,wOuttime,wPrice,wSaddress,wRaddress,wRphone,sInid,sOutid));
                }
            } catch (Exception ex) {
                return new Result().error(ex.getMessage());
            }
        }
        /* 根据订单状态进行查询
         *
         * @return
         */
        @GetMapping("/getCount")
        public Result getCount(@RequestParam(defaultValue = "0")Integer cId, @RequestParam(defaultValue = "0")Integer sInid) {
            try {
                int wyc = waybillService.countType("已运输",cId,sInid);
                int ysz = waybillService.countType("运输中",cId,sInid);
                int dys = waybillService.countType("待运输",cId,sInid);
                Map<String,String> map = new HashMap<>();
                map.put("ywc",String.valueOf(wyc));
                map.put("ysz",String.valueOf(ysz));
                map.put("dys",String.valueOf(dys));
                return new Result(0, "ok", map);
            } catch (Exception ex) {
                return new Result().error(ex.getMessage());
            }
        }
        /* 根据订单状态进行查询
         *
         * @return
         */
        @GetMapping("/updateSet")
        public Result updateSet(@RequestParam(defaultValue = "0") Integer wId, String wStatus,Integer wOuttime){
            try {
                if(waybillService.updateSet( wId,  wStatus,  wOuttime)>0){
                    return new Result(200, "操作成功！");
                }
                return new Result().error("操作失败！");
            } catch (Exception ex) {
                return new Result().error(ex.getMessage());
            }
        }


    }


