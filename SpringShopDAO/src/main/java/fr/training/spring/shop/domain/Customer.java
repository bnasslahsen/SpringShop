package fr.training.spring.shop.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "customerID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerID;

	@Column
	private String name;

	@Column
	private String password;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	private List<Order> orders;

	public Customer(Long customerID, String name, String password) {
		this.customerID = customerID;
		this.name = name;
		this.password = password;
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Long customerID) {
		this.customerID = customerID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
