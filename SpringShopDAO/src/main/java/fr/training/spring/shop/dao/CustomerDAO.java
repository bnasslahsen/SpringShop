package fr.training.spring.shop.dao;

import fr.training.spring.shop.domain.Customer;

public interface CustomerDAO {

	void create(Customer customer);

	Customer findOne(Long customerID);
}
