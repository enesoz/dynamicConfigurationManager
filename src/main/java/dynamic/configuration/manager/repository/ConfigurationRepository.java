package dynamic.configuration.manager.repository;

import dynamic.configuration.manager.entity.ConfigurationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConfigurationRepository extends MongoRepository<ConfigurationEntity, Long> {

    List getAllByAppNameAndActiveIsTrue(String appName);

    ConfigurationEntity getConfigurationEntityByAppNameAndNameAndActiveIsTrue(String appName, String name);


}
