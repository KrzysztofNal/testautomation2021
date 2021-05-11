package pl.tmobile.prepaidqa.qaapi.azure.model.activities;

import java.time.LocalDateTime;

public class Activities {
    private long id;
    private String title;
    private String dueDate;
    private boolean completed;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }
}
