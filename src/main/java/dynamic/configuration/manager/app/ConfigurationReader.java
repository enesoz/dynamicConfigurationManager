package dynamic.configuration.manager.app;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import dynamic.configuration.manager.ManagerApplication;
import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.entity.ManagerConfiguration;
import dynamic.configuration.manager.enums.AccessibleType;
import dynamic.configuration.manager.service.ConfigurationService;
import dynamic.configuration.manager.service.DynamicManager;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Service
public class ConfigurationReader {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationReader.class);

    //using for property of run parameters
    @Autowired
    ManagerConfiguration managerConfiguration;

    @Autowired
    ConfigurationService configurationService;


    protected ConfigurationReader() {
        // Exists only to clear object
    }

    protected ConfigurationReader(String applicationName, String connectionString, int refreshTimerIntervalInMs) {


    }

    /**
     * Paratemer Handler
     *
     * @param applicationName
     * @param connectionString
     * @param refreshTimerIntervalInMs
     * @return
     */
    public ConfigurationReader build(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
        ConfigurationReader retVal = new ConfigurationReader();

        managerConfiguration.setApplicationName(applicationName);
        if (!StringUtils.isEmpty(connectionString)) { // can be empty , work with default settings
            managerConfiguration.setConnectionString(connectionString);
        }
        managerConfiguration.setRefreshTimerIntervalInMs(refreshTimerIntervalInMs);
        return retVal;

    }

    /**
     * @param key Configuration Name
     * @param <T>
     * @return Configuration value as defined type
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    public <T> T getValue(String key) throws Exception {
        ConfigurationEntity entity = configurationService.getByName(managerConfiguration.getApplicationName(), key);
        if (entity == null) {
            throw new Exception("No Result For this");
        }
        switch (entity.getType()) {
            case STRING:
                return (T) entity.getValue();
            case DOUBLE:
                return (T) Double.valueOf(entity.getValue());
            case BOOLEAN:
                return (T) Boolean.valueOf(entity.getValue());
            case INTEGER:
                return (T) Integer.getInteger(entity.getValue());
            default:
                return (T) entity.getValue();

        }
    }

}
