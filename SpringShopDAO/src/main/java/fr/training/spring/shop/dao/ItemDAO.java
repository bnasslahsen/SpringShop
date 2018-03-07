package fr.training.spring.shop.dao;

import java.util.List;

import fr.training.spring.shop.domain.Item;

public interface ItemDAO {

	List<Item> getAllItems();

	void addItem(Item item);

}
