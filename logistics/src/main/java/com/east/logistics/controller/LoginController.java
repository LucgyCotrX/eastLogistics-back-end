package com.east.logistics.controller;

import com.east.logistics.service.LoginService;
import com.east.logistics.service.StaffService;
import com.east.logistics.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    private StaffService staffService;

   /**
     *  手机号码或者账号 密码登录
     * @param phone
     * @param password
     * @return
     */
   @RequestMapping("/auth")
   public Result authLogin(String phone, String password, @RequestParam(defaultValue = "0") int sf) {
       if(sf == 0 ){
           return loginService.loginAdmin(phone,password);
       }else {
           return loginService.loginStaff(phone,password);
       }

    }

    @RequestMapping("/staffauth")
    public Result staffAuthLogin(String phone, String password) {
            return loginService.loginStaff(phone,password);
        }


    /**
     * 获取验证码
     * sf
     * 0管理员
     * 1客户
     * 否则 司机
     * @param phone
     * @param sf
     * @return
     */
    @GetMapping("/getyzm")
    public Result getYzm(String phone, @RequestParam(defaultValue = "0") int sf) {
        return loginService.getYzm(phone,sf);
    }


    /**
     *  手机号码登录
     * sf
     * 0管理员
     * 1客户
     * 否则 司机
     * @param phone
     * @return
     */
    @GetMapping("/yzm")
    public Result yzm(String phone, @RequestParam(defaultValue = "0") int sf, @RequestParam(defaultValue = "0") int yzm) {
        return loginService.yzm(phone, sf,yzm);
    }

    /**
     * 退出
     */
    @GetMapping("/logout")
    public Result logout() {
        return loginService.logout();
    }
    /**
     * 身份验证不通过
     */
    @GetMapping("/verificationFailed")
    public Result verificationFailed() {
        return Result.error(502,"未登录");
    }
    /**
     * 权限不足
     */
    @GetMapping("/insufficientAuthority")
    public Result insufficientAuthority() {
        return Result.error(501,"权限不足");
    }

}
