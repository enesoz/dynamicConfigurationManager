package dynamic.configuration.manager.app;

import dynamic.configuration.manager.entity.ManagerConfiguration;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.inject.Singleton;

@Singleton
@ApplicationScope
public class ConfigurationReader {

    private static ManagerConfiguration managerConfiguration;

    public ConfigurationReader(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
        super();
        this.managerConfiguration = managerConfiguration;
    }

}
