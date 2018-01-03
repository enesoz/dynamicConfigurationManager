package dynamic.configuration.manager;

import dynamic.configuration.manager.app.ConfigurationReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration()
@SpringBootTest
public class ManagerApplicationTests {

    @Test
    public void contextLoads() {
        ConfigurationReader config = ConfigurationReader.build("deneme", "mongodb://localhost:27017/configurationDB", 300);
        assert config.start();
    }

}
