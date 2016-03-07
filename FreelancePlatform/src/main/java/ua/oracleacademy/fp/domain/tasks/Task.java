package ua.oracleacademy.fp.domain.tasks;

import java.time.LocalDateTime;
import java.util.Set;

public class Task {
    private long            id;
    private long            userId;
    private String userName;
    private String price;
    private String          title;
    private String          description;
    private LocalDateTime dateAdded;
    private boolean         status;

    private Set <Request> requests;

    public Task () {
    }

    public LocalDateTime getDateAdded() {
        return dateAdded;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public long getUserId() {
        return userId;
    }

    public boolean getStatus() {
        return status;
    }

    public void setDateAdded(LocalDateTime dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setRequests(Set<Request> requestSet) {
        this.requests = requestSet;
    }

    public Set <Request> getRequests() {
        return requests;
    }

    @Override
    public String toString() {
        return "Task["
                + " id: " + this.id
                + ", user_id: " + this.userId
                + ", price: " + this.price
                + ", title: " + this.title
                + ", description: " + this.description
                + ", date_added: " + this.dateAdded
                + ", status: " + this.status
                + " ]";
    }






}
