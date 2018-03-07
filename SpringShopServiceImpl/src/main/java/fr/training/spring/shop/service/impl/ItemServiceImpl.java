package fr.training.spring.shop.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import fr.training.spring.shop.dao.ItemDAO;
import fr.training.spring.shop.domain.Item;
import fr.training.spring.shop.dto.ItemDTO;
import fr.training.spring.shop.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDAO itemDAO;

	@Override
	@Cacheable("itemCache")
	public List<ItemDTO> getAllItems() {
		List<Item> items = itemDAO.getAllItems();
		List<ItemDTO> result = new ArrayList<>(items.size());
		for (int i = 0; i < items.size(); i++) {
			ItemDTO target = new ItemDTO();
			BeanUtils.copyProperties(items.get(i), target);
			result.add(target);
		}
		return result;
	}

	@Override
	@CacheEvict(value = "itemCache", allEntries = true)
	public void addItem(ItemDTO itemDTO) {
		Item item = new Item();
		BeanUtils.copyProperties(itemDTO, item);
		itemDAO.addItem(item);
	}

	@Override
	public ItemDTO getItem(Long itemID) {
		// not a very efficient implementation...
		if (itemID != null) {
			List<ItemDTO> items = getAllItems();
			for (ItemDTO item : items) {
				if (item.getItemID() == itemID) {
					return item;
				}
			}
		}
		return null;
	}

}
