package cn.wolfcode.shiro.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

/**
 * Created by Administrator on 2018/2/1.
 */
public class PasswordTest {

    @Test
    public void test() throws Exception {
        Md5Hash md5 = new Md5Hash("666");
        System.out.println("md5_无盐_1次散列:" + md5.toString());
        Md5Hash md5_salt_1 = new Md5Hash("666", "zhangsan", 1);
        System.out.println("md5_加盐_1次散列:" + md5_salt_1.toString());
        Md5Hash md5_salt1_1 = new Md5Hash("666", "lisi", 1);
        System.out.println("md5_加盐_1次散列:" + md5_salt1_1.toString());
        Md5Hash md5_salt1_2 = new Md5Hash("666", "lisi", 2);
        System.out.println("md5_加盐_2次散列:" + md5_salt1_2.toString());

        SimpleHash hash = new SimpleHash("md5", "666", "zhangsan", 1);
        System.out.println(hash);
    }
}
