package dynamic.configuration.manager.app;

import dynamic.configuration.manager.entity.ManagerConfiguration;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.inject.Singleton;

@Singleton
public class ConfigurationReader {

    public static ManagerConfiguration managerConfiguration;

    public ConfigurationReader(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
        this.managerConfiguration = new ManagerConfiguration(applicationName, connectionString, refreshTimerIntervalInMs);
    }

    public ManagerConfiguration getManagerConfiguration() {
        return managerConfiguration;
    }


}
