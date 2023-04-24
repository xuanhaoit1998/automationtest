package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import common.FavoriteReport;
import common.FavoriteUserReport;
import entiy.Favorite;
import entiy.User;
import entiy.Video;
import tienich.JpaUtils;



public class FavoriteDAO {
	private EntityManager em = JpaUtils.getEntityManger();
	@Override
	protected void finalize() throws Throwable {
		em.close();
	}
	public Favorite create(Favorite entity) {
		em.getTransaction().begin();
		try {
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}

	public Favorite update(Favorite entity) {
		em.getTransaction().begin();
		try {
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
		}
		return entity;
	}

	public Favorite remove(String id) {
		Favorite entity = null;
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
	public Favorite remove(String idUser, String idVideo) {
		Favorite entity = null;
		em.getTransaction().begin();
		try {
			TypedQuery<Favorite> query = em.createQuery("FROM Favorite where user.id = :idUser AND video.id = :idVideo", Favorite.class);
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

	public Favorite findById(String id) {
		Favorite entity = em.find(Favorite.class, id);
		return entity;
	}

	public List<Favorite> findAll() {
		TypedQuery<Favorite> query = em.createNamedQuery("findAll", Favorite.class);
		return query.getResultList();
	}
	public List<Video> findVideoByUserLike(User u) {
		TypedQuery<Video> query = em.createQuery("SELECT f.video FROM Favorite f WHERE f.user.id = :id", Video.class);
		query.setParameter("id", u.getId());
		return query.getResultList();
	}
	
	public List<FavoriteReport>reportFavoritesByVideos(){
		String jpql = "select new common.FavoriteReport(f.video.title,count(f),min(f.likeDate),max(f.likeDate)) "
				+ " from Favorite f group by f.video.title ";
		EntityManager em = JpaUtils.getEntityManger();
		List<FavoriteReport> list = null;
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			list = query.getResultList();
		}finally {
			em.close();
		}
		return list;
	}
	
	public List<FavoriteUserReport> reportFavoriteUsersByVideos(String id){
		String jpql="select new common.FavoriteUserReport(f.user.id,f.user.fullname,"
				+" f.user.email,f.likeDate) from Favorite f where f.video.id = :id";
		EntityManager em = JpaUtils.getEntityManger();
		List<FavoriteUserReport> list = null;
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
			query.setParameter("id", id);
			list = query.getResultList();
		}finally {
			em.close();
		}
		return list;
	}
}
