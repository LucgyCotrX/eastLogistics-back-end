package com.east.logistics.service;

import com.east.logistics.util.Result;


public interface LoginService {
    /**
     * 手机号码或者账号 密码 验证条件
     * @param dPhone
     * @return
     */
    Result loginAdmin(String dPhone, String Password);
    /**
     * 根据手机号码 身份 验证码 获取信息
     * @param phone
     * @return
     */
    Result yzm(String phone, int sf, int yzm);
    /**
     * 根据手机号码 获取信息验证码
     * @param phone
     * @return
     */
    Result getYzm(String phone, int sf);
    /**
     * 退出登录
     */
    Result logout();

    Result loginStaff(String phone, String password);
}
