package mapper.test;

import com.leaf.mybatis.user.User;
import com.leaf.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring/spring.xml")
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testTx() {
        User user = userService.selectByUserId(1);
        Assert.assertEquals(1, user.getUserId());

        System.out.println(user);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setUserId(2);
        user.setMobilePhone("112");
        user.setUserName("xxxx");

        int i = userService.addUser(user);
        Assert.assertEquals(1, i);

        System.out.println(user);
    }

    @Test
    public void testInsert2() {
        User user = new User();
        user.setUserId(6);
        user.setAge(1111);
        user.setMobilePhone("112");
        user.setUserName("xiao niu");

        int i = userService.doAddUser(user);
        Assert.assertEquals(1, i);

        System.out.println(user);
    }
}
