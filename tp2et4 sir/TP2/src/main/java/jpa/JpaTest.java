package jpa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import domain.Home;
import domain.Person;

public class JpaTest {
	private EntityManager manager;
	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory factory =   
 			 Persistence.createEntityManagerFactory("mysql");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);
		EntityTransaction tx = manager.getTransaction();
		tx.begin();
		try {
			test.createPerson();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();
		test.listPerson();
			
   	 manager.close();
		System.out.println(".. done");
	}
	private void createPerson() {
		int numOfPerson = manager.createQuery("Select a From Person a", Person.class).getResultList().size();
		if (numOfPerson == 0) {
			Home home = new Home("name");
			manager.persist(home);
			manager.persist(new Person("Jakab Gipsz",home, null));
			manager.persist(new Person("Captain Nemo",home, null));
		}
	}
	private void listPerson() {
		List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();
		System.out.println("num of person:" + resultList.size());
		for (Person next : resultList) {
			System.out.println("next person: " + next);
		}
	}
}