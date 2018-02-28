package dao;

import java.util.List;

import domain.Person;
import domain.Home;

/*import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;*/

public class PersonDAO implements GenericDao<Person, Long> {


    public Person create(Person o) {
        /*EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.persist(o);
        transaction.commit();*/
        EntityManagerHelper.getEntityManager().getTransaction().begin();
        EntityManagerHelper.getEntityManager().persist(o);
        EntityManagerHelper.getEntityManager().getTransaction().commit();
        return o;
    }

    public Person read(Long id) {
        return EntityManagerHelper.getEntityManager().find(Person.class, id);
    }

    public List<Person> readByName(String name) {
        return EntityManagerHelper.getEntityManager().createQuery("select p from Person as p where p.name = :name").setParameter("name", name).getResultList();
    }


    public List<Person> readAll() {
        return EntityManagerHelper.getEntityManager().createQuery("Select p from Person as p").getResultList();
    }

    public Person update(Person t) {
        return EntityManagerHelper.getEntityManager().merge(t);
    }

    public void delete(Person t) {
        EntityManagerHelper.getEntityManager().remove(t);

    }

    List<Person> getByMailDomain(String domain) {
        return EntityManagerHelper.getEntityManager().createQuery("select p from Person as p where p.name like '%.':domain").setParameter(domain, domain).getResultList();
    }




}