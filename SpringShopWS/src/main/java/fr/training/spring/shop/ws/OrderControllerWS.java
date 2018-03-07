package fr.training.spring.shop.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.training.spring.shop.dto.OrderDTO;
import fr.training.spring.shop.service.OrderService;

@RestController
public class OrderControllerWS {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public void addOrder(@RequestBody OrderDTO order) {
		orderService.addOrder(order);
	}

}
