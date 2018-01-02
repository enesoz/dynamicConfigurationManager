package dynamic.configuration.manager.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "reader")
public class ManagerConfiguration {

    private String applicationName;
    private String connectionString;
    private int refreshTimerIntervalInMs;

    public ManagerConfiguration() {
    }

    public ManagerConfiguration(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
        this.applicationName = applicationName;
        this.connectionString = connectionString;
        this.refreshTimerIntervalInMs = refreshTimerIntervalInMs;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getConnectionString() {
        return connectionString;
    }

    public void setConnectionString(String connectionString) {
        this.connectionString = connectionString;
    }

    public int getRefreshTimerIntervalInMs() {
        return refreshTimerIntervalInMs;
    }

    public void setRefreshTimerIntervalInMs(int refreshTimerIntervalInMs) {
        this.refreshTimerIntervalInMs = refreshTimerIntervalInMs;
    }
}
