package com.east.logistics.controller.aspect;

import com.east.logistics.util.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;


/*@Component
@Aspect
@EnableAspectJAutoProxy*/

/**
 * 暂时改为shiro
 */
public class jurisdictionAdvice {

    @Autowired


    public Result readOnly(ProceedingJoinPoint pj) throws Throwable {

             return (Result) pj.proceed();

  /*  //方法
        String method = pj.getSignature().getName();
        System.out.println(method);
        //获取用户
       String user = (String) httpSession.getAttribute("user");
       //模拟updateByPrimaryKey
       if(method.equals("updateByPrimaryKey")){
           user="100010003";
       }else {
           user="100010004";
       }
        //查询根据用户查询Network
       int jid = memberInformationService.selectJid(user);
        //获取权限
        System.out.println(jid);
        Jurisdiction jurisdiction = jurisdictionService.selectByPrimaryKey(jid);
        System.out.println(jurisdiction);
        //如果是最高管理
        if(jid == 1){
            try {
                return (Result) pj.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }//如果是中级管理 并方法是修改
        else if( jid == 2 && method.equals("updateByPrimaryKey")){
            try {
                return (Result) pj.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
            return new Result().error("权限不足");*/

    }
}
