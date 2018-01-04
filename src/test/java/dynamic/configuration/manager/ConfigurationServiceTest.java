package dynamic.configuration.manager;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.util.Version;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.Mongo;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.RuntimeConfig;
import de.flapdoodle.embed.process.distribution.IVersion;
import de.flapdoodle.embed.process.extract.UserTempNaming;
import dynamic.configuration.manager.entity.ConfigurationEntity;
import dynamic.configuration.manager.enums.AccessibleType;
import dynamic.configuration.manager.service.ConfigurationService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration
public class ConfigurationServiceTest {

	private static final String LOCALHOST = "127.0.0.1";
	private static final String DB_NAME = "itest";
	private static final int MONGO_TEST_PORT = 27028;

	private static MongodProcess mongoProcess;
	private static Mongo mongo;

	private MongoTemplate template;

	@Autowired
	ConfigurationService service;

	@BeforeClass
	public static void initializeDB() throws IOException {

		RuntimeConfig config = new RuntimeConfig();
		config.setExecutableNaming(new UserTempNaming());

		MongodStarter starter = MongodStarter.getInstance(config);

		MongodExecutable mongoExecutable = starter
				.prepare(new MongodConfig((IVersion) Version.parse("3.5.0"), MONGO_TEST_PORT, false));
		mongoProcess = mongoExecutable.start();

		mongo = new Mongo(LOCALHOST, MONGO_TEST_PORT);
		mongo.getDB(DB_NAME);
	}

	@AfterClass
	public static void shutdownDB() throws InterruptedException {
		mongo.close();
		mongoProcess.stop();
	}

	@After
	public void tearDown() throws Exception {
		service.getRepository().deleteAll();
	}

	@Test
	public void testGetByName() {
		String name = "SiteName";
	}

	@Test
	public void testGetConfigurations() {
		assertTrue(service.getConfigurations().size() >= 1);
	}

	@Test
	@Before
	public void testAdd() {
		ConfigurationEntity entity = ConfigurationEntity.createConfigurationEntity("siteName", AccessibleType.STRING,
				new String("enes.com"), true, "site1");
		assertNull(entity.getId());
		service.add(entity);
		assertNotNull(entity.getId());
	}

	@Test
	public void testUpdate() {
		ConfigurationEntity entity = service.getRepository().findOne("site");
		entity.setActive(false);
		service.update(entity);

		assertTrue(service.getRepository().findOne(entity.getName()).isActive() == false);
	}

	@Test
	public void testDeleteById() {
		ConfigurationEntity entity = ConfigurationEntity.createConfigurationEntity("deleted", AccessibleType.STRING,
				new String("deleted.com"), true, "site1");
		service.add(entity);

		service.deleteById(entity.getId());

		assertNotNull(service.getByName("deleted"));

	}

}
