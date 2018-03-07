package fr.training.spring.shop.web.model;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Min;

import fr.training.spring.shop.dto.ItemDTO;

public class OrderModel {

	@Min(2)
	private int orderID;

	private Integer customerID;

	private Set<Long> itemIDs;

	private List<ItemDTO> items;

	public Integer getOrderID() {
		return orderID;
	}

	public void setOrderID(Integer orderID) {
		this.orderID = orderID;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public Set<Long> getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(Set<Long> itemIDs) {
		this.itemIDs = itemIDs;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

}
