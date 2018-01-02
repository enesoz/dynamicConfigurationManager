package dynamic.configuration.manager.service;

import dynamic.configuration.manager.app.ConfigurationReader;
import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.repository.ConfigurationRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ConfigurationService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConfigurationService.class);

    @Autowired
    ConfigurationRepository repository;

    @Autowired
    ConfigurationReader configurationReader;


    public ConfigurationEntity getByName(String name) {
        return repository.getConfigurationEntityByAppNameAndNameAndActiveIsTrue(configurationReader.getManagerConfiguration().getApplicationName(), name);
    }

    public List getConfigurations() {
        return repository.getAllByAppNameAndActiveIsTrue(configurationReader.getManagerConfiguration().getApplicationName());
    }

    public ConfigurationRepository getRepository() {
        return repository;
    }


    public void add(ConfigurationEntity entity) {
        try {
            repository.save(entity);
            logger.info(entity.getName() + " added succesfully");
        } catch (Exception e) {
            logger.error("Couldn't save ", e.fillInStackTrace());
            throw e;
        }
    }


    public void update(ConfigurationEntity entity) {
        try {
            repository.save(entity);
            logger.info(entity.getName() + " updated succesfully");
        } catch (Exception e) {
            logger.error("Couldn't update ", e.fillInStackTrace());
            throw e;
        }
    }


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
