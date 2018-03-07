package fr.training.spring.shop.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "Orders")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "orderID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderID;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerID", nullable = false)
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "Orders_Items", inverseJoinColumns = @JoinColumn(name = "itemID", referencedColumnName = "itemID"), joinColumns = @JoinColumn(name = "orderID", referencedColumnName = "orderID"))
	private List<Item> items;

	public Order() {
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
