package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entiy.Share;
import entiy.User;
import entiy.Video;
import tienich.JpaUtils;



public class ShareDAO {
	private EntityManager em = JpaUtils.getEntityManger();
	@Override
	protected void finalize() throws Throwable {
		em.close();
	}
	public Share create(Share entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}

	public Share update(Share entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}

	public Share remove(String id) {
		Share entity = null;
		em.getTransaction().begin();
		try {
			entity = findById(id);
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}
	public Share remove(String idUser, String idVideo) {
		Share entity = null;
		em.getTransaction().begin();
		try {
			TypedQuery<Share> query = em.createQuery("FROM Share where user.id = :idUser AND video.id = :idVideo", Share.class);
			query.setParameter("idUser", idUser);
			query.setParameter("idVideo", idVideo);
			entity = query.getSingleResult();
			if(entity != null)
				em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}

	public Share findById(String id) {
		Share entity = em.find(Share.class, id);
		return entity;
	}

	public List<Share> findAll() {
		TypedQuery<Share> query = em.createNamedQuery("findAll", Share.class);
		return query.getResultList();
	}
	public List<Video> findVideoByUserLike(User u) {
		TypedQuery<Video> query = em.createQuery("SELECT f.video FROM Share f WHERE f.user.id = :id", Video.class);
		query.setParameter("id", u.getId());
		return query.getResultList();
	}
	
}

