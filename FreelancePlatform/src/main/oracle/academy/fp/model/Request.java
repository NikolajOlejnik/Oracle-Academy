package main.oracle.academy.fp.model;


import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REQUEST_ID")
    private long id;

    @Column(name = "TASK_ID")
    private long taskId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "DATE_ADDED")
    private Date dateAdded;

    @Column(name = "REQUEST_STATUS")
    private boolean status;

    public Request() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public boolean isActual() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Request["
                + " id: " + this.id
                + ", taskId: " + this.taskId
                + ", userId: " + this.userId
                + ", comment: " + this.comment
                + ", dateAdded: " + this.dateAdded
                + ", status: " + this.status
                + " ]";
    }


}
