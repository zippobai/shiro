package cn.wolfcode.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by Administrator on 2018/2/1.
 */
public class MyRealm extends AuthorizingRealm {

    @Override
    public String getName() {
        return "MyRealm";
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 根据前端传入的用户名从数据库中获取数据
        String username = (String) token.getPrincipal();
        // **********************模拟数据库********************
        if (!"zhangsan".equals(username)) {
            return null;
        }
        String password = "666";
        // ***************************************************
        // 构建认证信息对象, 此处不需要匹配用户密码, 用户密码比较是在认证器指定的 CredentialsMatcher 密码比较器比较密码
        // SimpleAuthenticationInfo(查询出的用户对象, 查询出来的用户密码, 当前的RealmName)
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, getName());
        return info;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }
}
