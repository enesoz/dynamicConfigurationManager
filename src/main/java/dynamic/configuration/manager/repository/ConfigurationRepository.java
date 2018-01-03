package dynamic.configuration.manager.repository;

import dynamic.configuration.manager.entity.ConfigurationEntity;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ConfigurationRepository extends MongoRepository<ConfigurationEntity, Long> {

    List getAllByAppNameAndActiveIsTrue(String appName);

    ConfigurationEntity getConfigurationEntityByAppNameAndNameAndActiveIsTrue(String appName, String name);

}
