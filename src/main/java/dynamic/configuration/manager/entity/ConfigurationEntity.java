package dynamic.configuration.manager.entity;

import dynamic.configuration.manager.enums.AccessibleType;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document
public class ConfigurationEntity extends BaseEntity {
    @Id
    private String id;
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

    public static Object createEmptyConfigurationEntity() {
        return new ConfigurationEntity();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (active ? 1231 : 1237);
        result = prime * result + ((appName == null) ? 0 : appName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ConfigurationEntity other = (ConfigurationEntity) obj;
        if (active != other.active)
            return false;
        if (appName == null) {
            if (other.appName != null)
                return false;
        } else if (!appName.equals(other.appName))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (type != other.type)
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

}
