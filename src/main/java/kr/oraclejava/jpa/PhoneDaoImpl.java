package kr.oraclejava.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

public class PhoneDaoImpl implements PhoneDao<Phone> {
	
	private EntityManager manager;
	
	public PhoneDaoImpl(EntityManager manager) {
		this.manager = manager;
	}

	public List<Phone> getAllEntity() {

		return manager.createQuery("from Phone").getResultList();
	}

	public List<Phone> findByField(String field, String find) {
		Query query = manager.createQuery("from Phone where " + field + "='" + find + "'");
		return query.getResultList();
	}

	public void addEntity(Phone entity) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.persist(entity);
		manager.flush();
		transaction.commit();

	}

	public void updateEntity(Phone entity) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.merge(entity);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(Phone entity) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(entity);
		manager.flush();
		transaction.commit();
	}

	public void removeEntity(Integer id) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		Phone phone = manager.find(Phone.class, id);
		manager.remove(phone);
		manager.flush();
		transaction.commit();

	}

}
