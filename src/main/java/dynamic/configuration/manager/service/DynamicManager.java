package dynamic.configuration.manager.service;

public interface DynamicManager {

     DynamicManager build(String applicationName, String connectionString, int refreshTimerIntervalInMs);

     <T> T getValue(String key);

}
