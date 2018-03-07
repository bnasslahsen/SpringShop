package fr.training.spring.shop.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Item implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "itemID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long itemID;

	@Column
	private String description;

	@Column
	private int price;

	@ManyToMany(mappedBy = "items")
	private List<Order> orders;

	public Item() {
	}

	public Item(long itemID, String description, int price) {
		this.itemID = itemID;
		this.description = description;
		this.price = price;
	}

	public long getItemID() {
		return itemID;
	}

	public void setItemID(long itemID) {
		this.itemID = itemID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
