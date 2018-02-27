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
public class LoginAndLogoutRealmTest {

    @Test
    public void test() throws Exception {
        // 1. 创建 SecurityManager 工厂
        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        // 2. 通过工厂创建 SecurityManager 实例
        SecurityManager securityManager = securityManagerFactory.getInstance();
        // 3. 将 SecurityManager 加入到运行时环境
        SecurityUtils.setSecurityManager(securityManager);
        // 4. 创建 Subject
        Subject subject = SecurityUtils.getSubject();
        // 5. 构建认证令牌
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "666");
        // 6. 执行登录
        try {
            subject. login(token);
        } catch (Exception e) {
            // 登录失败时抛出异常
            e.printStackTrace();
        }
        System.out.println("是否登录成功:" + subject.isAuthenticated());
        // 7. 登出
        subject.logout();
        System.out.println("是否登录成功:" + subject.isAuthenticated());
    }
}
