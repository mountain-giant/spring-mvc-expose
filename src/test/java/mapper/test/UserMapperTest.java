package mapper.test;

import com.leaf.mybatis.mapper.UserMapper;
import com.leaf.mybatis.user.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/spring/spring.xml")
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void selectByUserId() {
        User user = userMapper.selectByUserId(1);
        Assert.assertEquals(1, user.getUserId());
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("rainbow");
        user.setMobilePhone("119");
        user.setAge(11);

        int i = userMapper.insertUser(user);
        Assert.assertEquals(1, i);
    }
}
