package fr.training.spring.shop.service;

import java.util.List;

import fr.training.spring.shop.dto.ItemDTO;

public interface ItemService {

	List<ItemDTO> getAllItems();

	void addItem(ItemDTO item);

	ItemDTO getItem(Long itemID);

}
