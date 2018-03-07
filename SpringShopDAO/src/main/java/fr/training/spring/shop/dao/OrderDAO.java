package fr.training.spring.shop.dao;

import java.util.List;

import fr.training.spring.shop.domain.Order;

public interface OrderDAO {

	List<Order> getOrdersForCustomer(long customerID);

	void addOrder(Order order);

	void addOrders(List<Order> orders);

}
