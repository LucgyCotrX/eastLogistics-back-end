package com.east.logistics.shiro;

import com.east.logistics.dao.AdminMapper;
import com.east.logistics.dao.StaffMapper;
import com.east.logistics.entity.Admin;
import com.east.logistics.entity.Staff;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: east
 * @description: 自定义Realm
 * @date: 2019/04/27 20:10
 */
@Service
public class JWTRealm extends AuthorizingRealm {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
	private AdminMapper adminMapper;

	@Autowired
	private StaffMapper staffMapper;



    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String mUser = JWTUtil.getUsername(principals.toString());
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//获取用户信息
        Admin user = adminMapper.selectByPrimaryKey(Integer.parseInt(mUser.substring(1,mUser.length())));
        //用户的角色
		if("管理员".equals(user.getaType()))
		authorizationInfo.addStringPermission("admin");
		return authorizationInfo;
	}

    /**
     * 使用JWT替代原生Token
     * 须在此方法中显式的进行替换，否则在进行判断时会一直失败
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

	/**
	 *
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)  {
		//获取密钥
		String token = (String) authenticationToken.getPrincipal();
		// 解密获得username，用于和数据库进行对比
		String username = JWTUtil.getUsername(token);
        if(username == null){
            //没找到token
			return null;
            //throw new UnknownAccountException("密钥无效");
        }

		//从数据库查询是否存在

		String bd = null;
        int id = 0;
		if(username.length()>1){
			 bd = username.substring(0,1);
			 id = Integer.parseInt(username.substring(1,username.length()));
		}else{
			return null;
		}
		if("A".equals(bd)){
			Admin admin = adminMapper.selectByPrimaryKey(id);
			if (admin == null){
				return null;
			}
			if (! JWTUtil.verify(token, username, admin.getaPassword())) {
				return null;
				//throw new AuthenticationException("账号密码有误");
			}
		}
		else if("S".equals(bd)){
			Staff staff = staffMapper.selectByPrimaryKey(id);
			if(staff == null){
				return null;
			}
			if (! JWTUtil.verify(token, username, staff.getsPassword())) {
				return null;
				//throw new AuthenticationException("账号密码有误");
			}
		}else{
			return null;
		}
		return new SimpleAuthenticationInfo(token,token,getName());
	}
}
