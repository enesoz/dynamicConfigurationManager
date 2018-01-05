package dynamic.configuration.manager.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import dynamic.configuration.manager.ManagerApplication;
import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.enums.AccessibleType;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ManagerApplication.class)
public class ConfigurationServiceTest {

	@Autowired
	ConfigurationService service;

	@Before
	public void setup() {
		assertNotNull(service);
		ConfigurationEntity entity = ConfigurationEntity.createConfigurationEntity("deneme", AccessibleType.STRING,
				"deneme", true, "site1");
		service.add(entity);
	}

	@Test
	@Order(value = 1)
	public void contexLoads() throws Exception {
		assertNotNull(service);
	}

	@Test
	public void getByName() {
		ConfigurationEntity entity = service.getByName("site1", "deneme");
		assertNotNull(entity);
	}

	@Test
	public void getConfigurations() {
		assertTrue(service.getConfigurations().size() > 1);
	}

	@Test
	public void add() {
		ConfigurationEntity entity = ConfigurationEntity.createConfigurationEntity("deneme1", AccessibleType.STRING,
				"deneme1", true, "site2");
		assertNull(entity.getId());
		service.add(entity);
		assertNotNull(entity.getId());
	}

	@Test
	public void update() {
		ConfigurationEntity entity = ConfigurationEntity.createConfigurationEntity("deneme2", AccessibleType.STRING,
				"deneme2", true, "site2");
		service.add(entity);
		ConfigurationEntity updatedEntity = ConfigurationEntity.createConfigurationEntity(entity.getName(),
				entity.getType(), entity.getValue(), entity.isActive(), entity.getAppName());
		updatedEntity.setName("deneme22");
		service.update(entity);
		assertNotEquals(entity, updatedEntity);
	}

	@Test
	public void deleteById() {
		ConfigurationEntity entity = ConfigurationEntity.createConfigurationEntity("deneme2", AccessibleType.STRING,
				"deneme2", true, "site2");
		service.add(entity);
		assertNotNull(entity.getId());
		service.deleteById(entity.getId());
		assertFalse(service.getConfigurations().contains(entity));

	}

}