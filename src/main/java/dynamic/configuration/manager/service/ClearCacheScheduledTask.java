package dynamic.configuration.manager.service;

import dynamic.configuration.manager.app.ConfigurationReader;
import dynamic.configuration.manager.entity.ManagerConfiguration;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClearCacheScheduledTask {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ClearCacheScheduledTask.class);

    @Value("${reader.refreshTimerIntervalInMs}")
    public static String refreshTimerIntervalInMs;

    //    @Scheduled(fixedRateString = "${reader.refreshTimerIntervalInMs}")
    @CacheEvict(allEntries = true)
    public void cacheReset() {
        System.out.println("All Cache Cleared period with:" + "${reader.refreshTimerIntervalInMs}");
        logger.info("All Cache Cleared period with:" + "${reader.refreshTimerIntervalInMs}");
    }

}
