package dynamic.configuration.manager.entity;

import java.util.Date;

public class BaseEntity {

    private Date createdTime;
    private Date updatedTime;

    public BaseEntity() {
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
