package fr.training.spring.shop.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.training.spring.shop.dao.CustomerDAO;
import fr.training.spring.shop.domain.Customer;
import fr.training.spring.shop.dto.CustomerDTO;
import fr.training.spring.shop.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	public void create(CustomerDTO customerDTO) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerDTO, customer);
		customerDAO.create(customer);
	}

}
