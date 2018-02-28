package dao;

import domain.Home;
//import domain.Person;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HomeDAO implements GenericDao<Home,Long>{

	public Home create(Home t) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(t);
		transaction.commit();
		EntityManagerHelper.getEntityManager().getTransaction().begin();
		EntityManagerHelper.getEntityManager().persist(t);
		EntityManagerHelper.getEntityManager().getTransaction().commit();

		return t;
	}

	public Home read(Long id) {
		return EntityManagerHelper.getEntityManager().find(Home.class, id);
	}

	public Home update(Home t) {
		return EntityManagerHelper.getEntityManager().merge(t);
	}

	public void delete(Home t) {
		EntityManagerHelper.getEntityManager().remove(t);
		
	}

	public  List<Home> readAll() {
		return EntityManagerHelper.getEntityManager().createQuery("select h from Home as h").getResultList();
	}

}
