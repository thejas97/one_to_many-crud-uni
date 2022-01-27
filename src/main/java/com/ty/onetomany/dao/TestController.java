package com.ty.onetomany.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.AmazonOrder;
import com.ty.onetomany.dto.Item;

public class TestController {

	 EntityManagerFactory entityManagerFactory = null;
	 EntityManager entityManager = null;
	 EntityTransaction entityTransaction = null;

	public EntityManager getEntityManager() {

		entityManagerFactory = Persistence.createEntityManagerFactory("developer");
		entityManager = entityManagerFactory.createEntityManager();

		return entityManager;
	}

	public void save(AmazonOrder amazonOrder) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.persist(amazonOrder);
		entityTransaction.commit();
	}

	public AmazonOrder getOrder(int id) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);

		entityTransaction.commit();

		return amazonOrder;
	}

	public void updateOrder(AmazonOrder amazonOrder, Item item) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		entityManager.merge(amazonOrder);

		entityTransaction.commit();
	}

	public void deleteOrder(int id) {

		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		AmazonOrder amazonOrder = entityManager.find(AmazonOrder.class, id);

		if (amazonOrder != null) {
			entityManager.remove(amazonOrder);

		}

	}
}
