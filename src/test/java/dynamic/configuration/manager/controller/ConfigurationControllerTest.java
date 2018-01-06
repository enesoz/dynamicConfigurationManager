package dynamic.configuration.manager.controller;

import dynamic.configuration.manager.service.ConfigurationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(ConfigurationController.class)
public class ConfigurationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ConfigurationService service;

    public ConfigurationControllerTest() {
    }

    @Test
    public void index() {
    }

    @Test
    public void processAdd() {
    }

    @Test
    public void addConfiguration() {
    }

    @Test
    public void updateConfiguration() {
    }

    @Test
    public void deleteConfiguration() {
    }
}