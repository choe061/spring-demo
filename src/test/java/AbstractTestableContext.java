import com.choi.spring.config.DatabaseConfig;
import com.choi.spring.config.MyBatisConfig;
import com.choi.spring.service.UserServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by choi on 2017. 6. 3..
 */
@Transactional
@Rollback
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {DatabaseConfig.class, MyBatisConfig.class, UserServiceImpl.class})
public abstract class AbstractTestableContext {
}
