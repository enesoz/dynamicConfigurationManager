package dynamic.configuration.manager;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class ManagerApplication {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ManagerApplication.class);

    public static void main(String[] args) {
        logger.info("Application starting");
        SpringApplication.run(ManagerApplication.class, args);
    }


}
