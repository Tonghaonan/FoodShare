import com.food.FoodShareApplication;
import com.food.dao.UserDao;
import com.food.service.UserService;
import com.food.vo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= FoodShareApplication.class)
public class test {
    @Autowired
    private UserDao userDao;
    @Autowired
    UserService userService;

    @Test
    public void test3() throws Exception{
        User user = userService.selectByUsername("张三");
        System.out.println(user);
    }
    @Test
    public void test1() throws Exception{

        userDao.registry(new User(
                "赵六","123"
        ));

    }
    @Test
    public void test2() throws Exception {
        List<User> user = userDao.getUser(new User(
                "张三", "123"
        ));
        for (User u:user
             ) {
            System.out.println(u);
        }
    }

}
