package dynamic.configuration.manager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dynamic.configuration.manager.enums.AccessibleType;

import java.lang.reflect.Type;

@Document
public class ConfigurationEntity {
	@Id
	private long id;
	private String name;
	private AccessibleType type;
	private String value;
	private boolean active;
	private String appName;

	public ConfigurationEntity() {
	}

	public ConfigurationEntity(String name, AccessibleType type, String value, boolean active, String appName) {
		this.name = name;
		this.type = type;
		this.value = value;
		this.active = active;
		this.appName = appName;
	}

	public static ConfigurationEntity createConfigurationEntity(String name, AccessibleType type, String value,
			boolean active, String appName) {
		return new ConfigurationEntity(name, type, value, active, appName);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public AccessibleType getType() {
		return type;
	}

	public void setType(AccessibleType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

}
