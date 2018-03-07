package fr.training.spring.shop.web.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import fr.training.spring.shop.dto.ItemDTO;
import fr.training.spring.shop.dto.OrderDTO;
import fr.training.spring.shop.web.model.OrderModel;
import fr.training.spring.shop.web.utils.RestClientProperties;
import fr.training.spring.shop.web.utils.Utils;

@Controller
@Secured({ "ROLE_NORMAL_USER", "ROLE_ADMIN" })
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private RestClientProperties clientProperties;

	@RequestMapping("/addOrder")
	public ModelAndView showAddOrder(@ModelAttribute("orderModel") OrderModel orderModel) {
		ItemDTO[] response = restTemplate.getForObject(Utils.getUri(clientProperties, "/") + "items", ItemDTO[].class);
		List<ItemDTO> items = Arrays.asList(response);

		orderModel.setItems(items);
		return new ModelAndView("addOrder", "orderModel", orderModel);
	}

	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	@Secured({ "ROLE_NORMAL_USER", "ROLE_ADMIN" })
	public ModelAndView addOrder(@Valid OrderModel orderModel, BindingResult bindingResult) {
		Set<Long> itemIDs = orderModel.getItemIDs();

		if (itemIDs == null || itemIDs.isEmpty()) {
			bindingResult.rejectValue("itemIDs", null, "no items selected!");
		}
		if (orderModel.getCustomerID() == null) {
			bindingResult.rejectValue("customerID", null, "no customerID has been set!");
		}
		if (orderModel.getOrderID() == null) {
			bindingResult.rejectValue("orderID", null, "no orderID has been set!");
		}
		if (bindingResult.hasErrors()) {
			return showAddOrder(orderModel);
		}

		ItemDTO[] response = restTemplate.getForObject(Utils.getUri(clientProperties, "/") + "items", ItemDTO[].class);

		List<ItemDTO> allItems = Arrays.asList(response);
		List<ItemDTO> selectedItems = new ArrayList<ItemDTO>();
		for (ItemDTO item : allItems) {
			if (itemIDs.contains(item.getItemID())) {
				selectedItems.add(item);
			}
		}

		OrderDTO order = new OrderDTO(orderModel.getOrderID(), orderModel.getCustomerID());
		order.setItems(selectedItems);

		restTemplate.postForObject(Utils.getUri(clientProperties, "/") + "addOrder", order, OrderDTO.class);

		return new ModelAndView(new RedirectView("addOrder.html"));
	}

}
