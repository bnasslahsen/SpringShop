package fr.training.spring.shop.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.training.spring.shop.dao.CustomerDAO;
import fr.training.spring.shop.domain.Customer;

@Component
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Customer customer) {
		em.merge(customer);
	}

	@Override
	public Customer findOne(Long customerID) {
		return em.find(Customer.class, customerID);
	}

}
