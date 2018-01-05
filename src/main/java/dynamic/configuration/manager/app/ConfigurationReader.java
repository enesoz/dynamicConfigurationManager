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

@Service
public class ConfigurationReader implements DynamicManager {

	//For Singleton instance
	private static ConfigurationReader instance = null;
	
	//using for property of run parameters
	public static ManagerConfiguration managerConfiguration;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationReader.class);

	@Autowired
	ConfigurationService configurationService;

	protected ConfigurationReader() {
		// Exists only to defeat instantiation.
	}

	protected ConfigurationReader(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
		this.managerConfiguration = new ManagerConfiguration(applicationName, connectionString,
				refreshTimerIntervalInMs);
	}

	protected boolean start(String[] args) {
		try {
			logger.info("Application starting");
			ConfigurableApplicationContext run = SpringApplication.run(ManagerApplication.class, args);
			return run.isActive();
		} catch (Exception e) {
			logger.error("Error Occured", e.fillInStackTrace());
		}
		return false;
	}

	public static DynamicManager build(String applicationName, String connectionString, int refreshTimerIntervalInMs) {
		if (instance == null) {
			instance = new ConfigurationReader(applicationName, connectionString, refreshTimerIntervalInMs);
		}
		return instance;
	}

	public ManagerConfiguration getManagerConfiguration() {
		return managerConfiguration;
	}


	@Override
	public DynamicManager start() {
		// start(args)
		return instance;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getValue(String key) {
		ConfigurationEntity entity = configurationService.getByName(managerConfiguration.getApplicationName(), key);
		return (T) entity.getValue();
	}

}
