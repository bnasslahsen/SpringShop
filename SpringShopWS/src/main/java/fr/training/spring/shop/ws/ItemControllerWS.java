package fr.training.spring.shop.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.training.spring.shop.dto.ItemDTO;
import fr.training.spring.shop.service.ItemService;

@RestController
public class ItemControllerWS {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/items", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ItemDTO> showItems() {
		return itemService.getAllItems();
	}

}
