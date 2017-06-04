import com.choi.spring.domain.User;
import com.choi.spring.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by choi on 2017. 6. 3..
 */
public class UserTest extends AbstractTestableContext {

    @Autowired
    private UserService userService;
    private User insertUser;

    @Before
    public void setUp() {
        insertUser = new User();
        insertUser.setName("gyoun");
        insertUser.setPw("123");
        insertUser.setLogin(0);
        insertUser.setRecommend(0);
        insertUser.setLevel(User.Level.BRONZE);
    }

    @Test
    public void insertUser() {
        userService.insertUser(insertUser);
    }

    @Test
    public void getUser() {
        User user = userService.getUser("choi");
        assertTrue(user.getName().equals("choi"));
    }

    @Test
    public void getUsers() {
        ArrayList<User> users = userService.getUsers();

        for (User userUnit : users) {
            System.out.println("id : "+userUnit.getId() + ", name : " + userUnit.getName() + ", level : "+userUnit.getLevel());
        }
    }
}
