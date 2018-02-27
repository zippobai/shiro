package cn.wolfcode.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018/2/1.
 */
public class RoleTest {

    @Test
    public void test() throws Exception {
        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        SecurityManager          securityManager        = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject             subject = SecurityUtils.getSubject();
        AuthenticationToken token   = new UsernamePasswordToken("zhangsan", "666");
        try {
            subject.login(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("是否登录成功:" + subject.isAuthenticated());

        // 判断是否拥有某些权限
        System.out.println("是否拥有某个角色:" + subject.hasRole("role3"));
        System.out.println("是否拥有某一些中的某一个角色:" + Arrays.toString(subject.hasRoles(Arrays.asList("role1", "role2", "role3"))));
        System.out.println("是否拥有某一些角色:" + subject.hasAllRoles(Arrays.asList("role1", "role2")));

//        subject.checkRole("role3");
        subject.checkRoles("role1", "role2", "role3");
    }
}
