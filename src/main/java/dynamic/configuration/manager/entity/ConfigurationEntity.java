package dynamic.configuration.manager.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.lang.reflect.Type;

@Document
public class ConfigurationEntity {
    @Id
    private long id;
    private String name;
    private Type type;
    private Object value;
    private boolean active;
    private String appName;

    public ConfigurationEntity() {
    }

    public ConfigurationEntity(String name, Type type, Object value, boolean active, String appName) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.active = active;
        this.appName = appName;
    }

    public static ConfigurationEntity createConfigurationEntity(String name, Type type, Object value, boolean active, String appName) {
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
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
