package dynamic.configuration.manager.service;

import dynamic.configuration.manager.app.ConfigurationReader;
import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.repository.ConfigurationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public class ConfigurationService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationService.class);

    @Autowired
    ConfigurationRepository repository;

    @Autowired
    ConfigurationReader configurationReader;

    @Cacheable(cacheNames = "getConfigurationByName")
    public ConfigurationEntity getByName(String name) {
        return repository.getConfigurationEntityByAppNameAndNameAndActiveIsTrue(configurationReader.getManagerConfiguration().getApplicationName(), name);
    }
    @Cacheable(cacheNames = "entities")
    public List getConfigurations() {
        return repository.getAllByAppNameAndActiveIsTrue(configurationReader.getManagerConfiguration().getApplicationName());
    }

    @CachePut(value = "entity"  ,key = "#id")
    public void add(ConfigurationEntity entity) {
        try {
            repository.save(entity);
            logger.info(entity.getName() + " added succesfully");
        } catch (Exception e) {
            logger.error("Couldn't save ", e.fillInStackTrace());
            throw e;
        }
    }

    @CachePut(value = "entity"  ,key = "#id")
    public void update(ConfigurationEntity entity) {
        try {
            repository.save(entity);
            logger.info(entity.getName() + " updated succesfully");
        } catch (Exception e) {
            logger.error("Couldn't update ", e.fillInStackTrace());
            throw e;
        }
    }

    @CacheEvict(value = "post-single", key = "#id")
    public void deleteById(long id) {
        try {
            repository.deleteById(id);
            logger.info(id + " entity deleted succesfully");
        } catch (Exception e) {
            logger.error("Couldn't update ", e.fillInStackTrace());
            throw e;
        }
    }
}
