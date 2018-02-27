package cn.wolfcode.shiro.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by Administrator on 2018/2/1.
 */
public class PasswordRealmTest {

    @Test
    public void test() throws Exception {
        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-cryptography.ini");
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
        subject.logout();
        System.out.println("是否登录成功:" + subject.isAuthenticated());
    }
}
