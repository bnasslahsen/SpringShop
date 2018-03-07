import java.util.List;

import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.CollectionUtils;

import fr.training.spring.shop.dto.CustomerDTO;
import fr.training.spring.shop.dto.ItemDTO;
import fr.training.spring.shop.dto.OrderDTO;
import fr.training.spring.shop.service.CustomerService;
import fr.training.spring.shop.service.ItemService;
import fr.training.spring.shop.service.OrderService;

public class Main {

	private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(Main.class);
	private static ApplicationContext ctx;

	public static void main(String[] args) {

		ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		CustomerService customerService = (CustomerService) ctx.getBean("customerServiceImpl");

		// Initialisation
		CustomerDTO customerDTO = new CustomerDTO(99, "nass", "123456");
		customerService.create(customerDTO);

		ItemService itemService = (ItemService) ctx.getBean("itemServiceImpl");
		ItemDTO item1 = new ItemDTO(1, "Desc 1", 100);
		itemService.addItem(item1);
		ItemDTO item2 = new ItemDTO(2, "Desc 2", 200);
		itemService.addItem(item2);
		ItemDTO item3 = new ItemDTO(3, "Desc 3", 300);
		itemService.addItem(item3);
		ItemDTO item4 = new ItemDTO(4, "Desc 4", 400);
		itemService.addItem(item4);

		// Businees
		OrderService orderService = (OrderService) ctx.getBean("orderServiceImpl");

		OrderDTO orderDTO = new OrderDTO(1, 1);
		orderDTO.addItem(item1);
		orderDTO.addItem(item2);
		orderService.addOrder(orderDTO);
		orderDTO = new OrderDTO(2, 1);
		orderDTO.addItem(item1);
		orderService.addOrder(orderDTO);
		orderDTO = new OrderDTO(3, 1);
		orderDTO.addItem(item1);
		orderService.addOrder(orderDTO);

		List<OrderDTO> orderDTOs = orderService.getOrdersForCustomer(99);

		if (!CollectionUtils.isEmpty(orderDTOs)) {
			LOG.info("Liste des ordres: " + orderDTO);
		}
		orderService.getOrdersForCustomer(1);
		orderService.getOrdersForCustomer(1);
		orderService.getOrdersForCustomer(1);

		LOG.info("Liste des items: " + itemService.getAllItems());
		LOG.info("Liste des items: " + itemService.getAllItems());
		LOG.info("Liste des items: " + itemService.getAllItems());

	}
}
