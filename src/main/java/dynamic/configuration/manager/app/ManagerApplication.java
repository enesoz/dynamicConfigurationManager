package dynamic.configuration.manager.app;

import dynamic.configuration.manager.entity.ManagerConfiguration;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableConfigurationProperties(ManagerConfiguration.class)
@EnableCaching
@ComponentScan
public class ManagerApplication {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ManagerApplication.class);

    public static void main(String[] args) {
        logger.info("Application starting");
        SpringApplication.run(ManagerApplication.class, args);
    }


}
