package fr.training.spring.shop.service;

import java.util.List;

import fr.training.spring.shop.dto.OrderDTO;

public interface OrderService {

	List<OrderDTO> getOrdersForCustomer(long customerID);

	void addOrder(OrderDTO order);

	void addOrders(List<OrderDTO> orders);

}
