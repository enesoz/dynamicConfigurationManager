package dynamic.configuration.manager.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Controller
@ConfigurationProperties(prefix = "reader")
public class ManagerConfiguration {

    @NotNull
    private String applicationName;
    private String connectionString;
    @NotNull
    @Min(message = "Too less , Need to bigger 180000ms", value = 180000)
    private long refreshTimerIntervalInMs;

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

    public long getRefreshTimerIntervalInMs() {
        return refreshTimerIntervalInMs;
    }

    public void setRefreshTimerIntervalInMs(long refreshTimerIntervalInMs) {
        this.refreshTimerIntervalInMs = refreshTimerIntervalInMs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManagerConfiguration that = (ManagerConfiguration) o;
        return getRefreshTimerIntervalInMs() == that.getRefreshTimerIntervalInMs() &&
                Objects.equals(getApplicationName(), that.getApplicationName()) &&
                Objects.equals(getConnectionString(), that.getConnectionString());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getApplicationName(), getConnectionString(), getRefreshTimerIntervalInMs());
    }
}
