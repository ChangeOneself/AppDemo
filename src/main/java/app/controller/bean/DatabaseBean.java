package app.controller.bean;

import org.springframework.context.annotation.Bean;

public class DatabaseBean {
    private String databaseName;
    private String id;

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
