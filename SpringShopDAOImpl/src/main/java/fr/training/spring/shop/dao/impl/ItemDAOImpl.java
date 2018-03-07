package fr.training.spring.shop.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.training.spring.shop.dao.ItemDAO;
import fr.training.spring.shop.domain.Item;

@Component
@Transactional
public class ItemDAOImpl implements ItemDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Item> getAllItems() {
		String hql = "select it from Item it";
		TypedQuery<Item> query = em.createQuery(hql, Item.class);
		return query.getResultList();
	}

	@Override
	public void addItem(Item item) {
		em.merge(item);
	}

}
