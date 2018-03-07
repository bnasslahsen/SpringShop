package fr.training.spring.shop.dto;

import java.io.Serializable;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long customerID;

	private String name;

	private String password;

	public CustomerDTO(long customerID, String name, String password) {
		this.customerID = customerID;
		this.name = name;
		this.password = password;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
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
