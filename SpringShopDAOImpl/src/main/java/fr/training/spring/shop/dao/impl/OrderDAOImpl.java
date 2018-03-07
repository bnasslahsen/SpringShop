package fr.training.spring.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.training.spring.shop.dao.OrderDAO;
import fr.training.spring.shop.domain.Order;

@Component
@Transactional
public class OrderDAOImpl implements OrderDAO {

	@PersistenceContext
	private EntityManager em;

	public List<Order> getOrdersForCustomer(long customerID) {
		String hql = "select o from Orders o where o.customer.customerID like :customerID";
		TypedQuery<Order> query = em.createQuery(hql, Order.class);
		query.setParameter("customerID", customerID);
		return query.getResultList();
	}

	public void addOrder(Order order) {
		em.merge(order);
	}

	@Override
	public void addOrders(List<Order> orders) {
		for (Order order : orders) {
			em.merge(order);
		}

	}

}
