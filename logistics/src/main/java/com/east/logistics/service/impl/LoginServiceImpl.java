package com.east.logistics.service.impl;

import com.east.logistics.dao.AdminMapper;
import com.east.logistics.dao.StaffMapper;
import com.east.logistics.dao.VerificationCodeMapper;
import com.east.logistics.entity.Admin;
import com.east.logistics.entity.Staff;
import com.east.logistics.entity.VerificationCode;
import com.east.logistics.service.LoginService;
import com.east.logistics.service.SmsPhone;
import com.east.logistics.shiro.JWTUtil;
import com.east.logistics.util.LoginOk;
import com.east.logistics.util.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private VerificationCodeMapper verificationCodeMapper;
    @Autowired
    private SmsPhone smsPhone;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private StaffMapper staffMapper;
    /**
     * 使用司机手机号码 密码 验证条件 登录
     * @param dPhone
     * @param Password
     * @return
     */


    /**
     * 管理员根据手机号码或者账号 密码 验证条件
     * @param dPhone
     * @return
     */
    @Override
    public Result loginAdmin(String dPhone, String Password) {

            Admin admin = adminMapper.yzms(dPhone);
            if(admin == null){
                return Result.error("账号无效");
            }
            if(admin.getaPassword().equals(Password)){
                return Result.successMessage(1028,"登录成功", loginOkAdmin(admin));
            }
            return Result.error("用户名密码错误");
    }

    @Override
    public Result yzm(String phone, int sf, int yzm) {
        //管理员
        if (sf == 0 ) {
            VerificationCode verificationCode = verificationCodeMapper.selectLogin(phone, yzm);
            if (verificationCode == null) {
                return Result.error("验证码错误");
            }
            //获取用户
            Admin admin = adminMapper.yzm(phone);
            return Result.successMessage(1028, "登录成功", loginOkAdmin(admin));
        } else {
            VerificationCode verificationCode = verificationCodeMapper.selectLogin(phone,yzm);
            if(verificationCode == null){
                return  Result.error("验证码错误");
            }
            //获取用户
            Staff staff= staffMapper.yzm(phone);
            return Result.successMessage(1028,"登录成功", loginOkStaff(staff));
        }
    }


    /**sf
     * @param phone
     * @param sf
     * @return
     */
    @Override
    public Result getYzm(String phone, int sf) {
        //管理员
        if(sf == 0){
            //获取用户
            Admin admin = adminMapper.yzm(phone);
            if(admin == null){
                return new Result().error(1203,"手机号码无效！");
            }
            return new Result().success(smsPhone.send(phone));
        }
        else {
            //获取
            Staff staff= staffMapper.yzm(phone);
            if(staff == null){
                return new Result().error(1203,"手机号码无效！");
            }
            return new Result().success(smsPhone.send(phone));
        }
    }

    //管理员
    private static LoginOk loginOkAdmin(Admin admin){
        LoginOk loginOk = new LoginOk();
        loginOk.setmName(admin.getaAccount());
        loginOk.setmUser(admin.getaId().toString());
        loginOk.setSign(JWTUtil.sign("A"+admin.getaId().toString(), admin.getaPassword()));
        return loginOk;
    }
    @Override
    public Result logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
            return Result.successMessage("退出成功");
        }
        return Result.successMessage("退出成功");
    }

    @Override
    public Result loginStaff(String dPhone, String Password) {

        Staff staff = staffMapper.yzm(dPhone);
        if(staff == null){
            return Result.error("账号无效");
        }
        if(staff.getsPassword().equals(Password)){
            return Result.successMessage(1028,"登录成功", loginOkStaff(staff));
        }
        return Result.error("用户名密码错误");
    }

//业务员
    private static LoginOk loginOkStaff(Staff staff){
        LoginOk loginOk = new LoginOk();
        loginOk.setmName(staff.getsAccount());
        loginOk.setmUser(staff.getsId().toString());
        loginOk.setSign(JWTUtil.sign("S"+staff.getsId().toString(), staff.getsPassword()));
        return loginOk;
    }
}
