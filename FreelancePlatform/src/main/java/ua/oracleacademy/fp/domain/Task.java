package ua.oracleacademy.fp.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	@Column(name = "TASK_ID")
	@GeneratedValue
	private Integer id;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "CREATED")
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@Column(name = "PRICE")
	private Double price;

	private Customer customer;

	private Freelancer freelancer;

	@Column(name = "OWNER_ID")
	private long customerId;

	@Column(name = "FREELANCER_ID")
	private long freelancerId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		this.customerId = customer.getId();
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
		this.freelancerId = freelancer.getId();
	}

	public long getCustomerId() {
		return customerId;
	}


	public long getFreelancerId() {
		return freelancerId;
	}
}
