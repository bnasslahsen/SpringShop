package fr.training.spring.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.training.spring.shop.dao.CustomerDAO;
import fr.training.spring.shop.dao.OrderDAO;
import fr.training.spring.shop.domain.Item;
import fr.training.spring.shop.domain.Order;
import fr.training.spring.shop.dto.ItemDTO;
import fr.training.spring.shop.dto.OrderDTO;
import fr.training.spring.shop.service.OrderService;

@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public List<OrderDTO> getOrdersForCustomer(long customerID) {
		List<Order> orders = orderDAO.getOrdersForCustomer(customerID);
		List<OrderDTO> result = new ArrayList<>(orders.size());
		for (int i = 0; i < orders.size(); i++) {
			OrderDTO target = new OrderDTO();
			BeanUtils.copyProperties(orders.get(i), target);
			result.add(target);
		}
		return result;
	}

	@Override
	public void addOrder(OrderDTO orderDTO) {
		Order order = convertToBo(orderDTO);
		orderDAO.addOrder(order);
	}

	private Order convertToBo(OrderDTO orderDTO) {
		Order order = new Order();
		BeanUtils.copyProperties(orderDTO, order);
		List<ItemDTO> itemsDTO = orderDTO.getItems();
		List<Item> items = new ArrayList<>();
		for (ItemDTO itemDTO : itemsDTO) {
			Item item = new Item();
			BeanUtils.copyProperties(itemDTO, item);
			items.add(item);
		}
		order.setItems(items);
		order.setCustomer(customerDAO.findOne(orderDTO.getCustomerID()));
		return order;
	}

	@Override
	public void addOrders(List<OrderDTO> ordersDTO) {
		List<OrderDTO> orders = new ArrayList<>(ordersDTO.size());
		List<Order> result = new ArrayList<>(orders.size());
		for (int i = 0; i < ordersDTO.size(); i++) {
			result.add(convertToBo(ordersDTO.get(i)));
		}
		orderDAO.addOrders(result);
	}

}
