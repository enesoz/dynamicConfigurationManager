package dynamic.configuration.manager;

import dynamic.configuration.manager.service.ConfigurationService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigurationServiceTest {

    @MockBean
    ConfigurationService service;


}
