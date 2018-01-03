package dynamic.configuration.manager.app;

import dynamic.configuration.manager.entity.ManagerConfiguration;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
@Service
public class ConfigurationReader {

    private static ConfigurationReader instance = null;
    public static ManagerConfiguration managerConfiguration;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationReader.class);
    private String[] args;


    protected ConfigurationReader() {
        // Exists only to defeat instantiation.
    }

    protected ConfigurationReader(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
        this.managerConfiguration = new ManagerConfiguration(applicationName, connectionString, refreshTimerIntervalInMs);
    }


    public boolean start() {
        try {
            logger.info("Application starting");
            ConfigurableApplicationContext run = SpringApplication.run(ManagerApplication.class, args);
            return run.isActive();
        } catch (Exception e) {
            logger.error("Error Occured", e.fillInStackTrace());
        }
        return false;
    }

    public static ConfigurationReader build(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
        if (instance == null) {
            instance = new ConfigurationReader(applicationName, connectionString, refreshTimerIntervalInMs);
        }
        return instance;
    }


    public ManagerConfiguration getManagerConfiguration() {
        return managerConfiguration;
    }


}
