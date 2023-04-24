package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entiy.User;
import tienich.JpaUtils;



public class UserDAO {
	private EntityManager em = JpaUtils.getEntityManger();

	@Override
	protected void finalize() throws Throwable {
		em.close();
	}

	public User create(User entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}

	public User update(User entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}
	
	 
	public User remove(String id) {
		User entity = null;
		em.getTransaction().begin();
		try {
			entity = findById(id);
			if(entity != null)
				em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}

	public User findById(String id) {
		User entity = em.find(User.class, id);
		return entity;
	}

	public List<User> findAll() {
		TypedQuery<User> query = em.createQuery("FROM User", User.class);
		return query.getResultList();
	}
}
