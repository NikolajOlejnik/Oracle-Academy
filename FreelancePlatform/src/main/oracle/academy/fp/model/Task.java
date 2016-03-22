package main.oracle.academy.fp.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TASK_ID")
    private Long id;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "PRICE")
    private String price;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATE_ADDED")
    private Date dateAdded;

    @Column(name = "TASK_STATUS")
    private Boolean status;

//    private String smallDescription;
//
//    public String getSmallDescription() {
//        StringBuilder sb = new StringBuilder(this.description);
//        sb.delete(30, sb.length());
//        sb.append("...");
//        return sb.toString();
//    }
    //private List<Request> requests;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }



    //    public List<Request> getRequests() {
//        return requests;
//    }
//
//    public void setRequests(List<Request> requests) {
//        this.requests = requests;
//    }

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
