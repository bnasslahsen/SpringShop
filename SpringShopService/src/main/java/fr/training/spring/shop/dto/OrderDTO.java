package fr.training.spring.shop.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long orderID;

	private long customerID;

	private List<ItemDTO> items;

	public OrderDTO() {
	}

	public OrderDTO(long orderID, long customerID) {
		this.orderID = orderID;
		this.customerID = customerID;
		items = new ArrayList<ItemDTO>();
	}

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public long getCustomerID() {
		return customerID;
	}

	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDTO [orderID=");
		builder.append(orderID);
		builder.append(", customerID=");
		builder.append(customerID);
		builder.append(", items=");
		builder.append(items);
		builder.append("]");
		return builder.toString();
	}

	public void addItem(ItemDTO itemDTO) {
		items.add(itemDTO);
	}

}
