package dynamic.configuration.manager.app;

import dynamic.configuration.manager.entity.ManagerConfiguration;
import dynamic.configuration.manager.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties(ManagerConfiguration.class)
@EnableAutoConfiguration
@EnableCaching
public class ManagerApplication {

    public static void main(String[] args) {
        Con
        SpringApplication.run(ManagerApplication.class, args);
    }


}
