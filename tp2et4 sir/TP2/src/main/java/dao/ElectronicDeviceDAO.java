package dao;

/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;*/

import domain.ElectronicDevice;


public class ElectronicDeviceDAO implements GenericDao<ElectronicDevice,Long> {

	public ElectronicDevice create(ElectronicDevice t) {
		 	/*EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
	        EntityManager manager = factory.createEntityManager();
	        EntityTransaction transaction = manager.getTransaction();
	        transaction.begin();
	        manager.persist(t);
	        transaction.commit();*/
		EntityManagerHelper.getEntityManager().getTransaction().begin();
		EntityManagerHelper.getEntityManager().persist(t);
		EntityManagerHelper.getEntityManager().getTransaction().commit();
			 return t;
	}

	public ElectronicDevice read(Long id) {
		return EntityManagerHelper.getEntityManager().find(ElectronicDevice.class, id);
	}

	public ElectronicDevice update(ElectronicDevice t) {
		return EntityManagerHelper.getEntityManager().merge(t);
	}

	public void delete(ElectronicDevice t) {
		EntityManagerHelper.getEntityManager().remove(t);
		
	}

}
