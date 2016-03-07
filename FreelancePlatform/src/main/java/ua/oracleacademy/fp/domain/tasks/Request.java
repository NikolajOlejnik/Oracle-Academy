package ua.oracleacademy.fp.domain.tasks;

import java.time.LocalDateTime;

public class Request {
    private long            id;
    private long taskId;
    private long            userId;
    private String userName;
    private String          comment;
    private LocalDateTime dateAdded;
    private boolean         status;

    public Request() {
    }

    public String getComment() {
        return comment;
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public long getTaskId() {
        return taskId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "Request["
                + " id: "           + this.id
                + ", taskId: "   + this.taskId
                + ", userId: "      + this.userId
                + ", comment: "     + this.comment
                + ", dateAdded: "   + this.dateAdded
                + ", status: "      + this.status
                + " ]";
    }




}
