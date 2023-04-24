package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entiy.Video;
import tienich.JpaUtils;



public class VideoDAO extends AbstractEntityDAO<Video>{
	public VideoDAO() {
		super(Video.class);
		
	}
	private EntityManager em = JpaUtils.getEntityManger();
	
	public Video getVideobyId(String id) {
		Video v = em.find(Video.class, id);
		return v;
	}

	public List<Video> getAll() {
		TypedQuery<Video> query = em.createQuery("FROM Video", Video.class);
		return query.getResultList();
	}

	public List<Video> getVideoPaging(int page) {
		TypedQuery<Video> query = em.createQuery("FROM Video ORDER BY views DESC", Video.class);
		query.setFirstResult(page * 6);
		query.setMaxResults(6);
		return query.getResultList();
	}

	public Long getTotalPage() {
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(*) FROM Video", Long.class);
		return (long) Math.ceil(query.getSingleResult() / 6.0);
	}

	public Boolean tangLuotXem(Video entity) {
		em.getTransaction().begin();
		try {
			entity.setViews(entity.getViews() + 1);
			em.merge(entity);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			em.getTransaction().rollback();
			return false;
		}
	}

	public List<Video> getVideo(List<String> idVideos) {
		TypedQuery<Video> query = em.createQuery("FROM Video WHERE id in (:idvideos)", Video.class);
		query.setParameter("idvideos", idVideos);
	
		return query.getResultList();
	}
	
	public Video findByID(String id) {
		Video entity = em.find(Video.class, id);
		return entity;
	}
	
	public Video remove(String id) {
		Video entity = null;
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
	public List<Object[]> getVideoFavorite(int page,String UserId) {
		TypedQuery<Object[]> query = em.createQuery("SELECT v.id as id, v.title as title, v.poster as poster, v.description as description ,"
				+ " v.views as views , v.active as active "
				+ " FROM Video v inner join Favorite f  on f.video.id=v.id  WHERE f.user.id="
				+ ":userId ORDER BY v.views DESC", Object[].class);
		query.setFirstResult(page * 6);
		query.setMaxResults(6);
		query.setParameter("userId", UserId);
		return query.getResultList();
	}
	public Long getTotalPage_1(String UserId) {
		TypedQuery<Long> query = em.createQuery("SELECT COUNT(*) FROM  Favorite f   WHERE f.user.id= :userId", Long.class);
		query.setParameter("userId", UserId);
		return (long) Math.ceil(query.getSingleResult() / 6.0);
	}
}
