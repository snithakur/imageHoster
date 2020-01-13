package ImageHoster.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;

@Repository
public class CommentRepository {

	@PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;
	
	public Comment createComment(Comment comment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(comment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return comment;
    }
	
	  public List<Comment> getCommentsByImageId(Integer imageId) {
	        EntityManager em = emf.createEntityManager();
	        TypedQuery<Comment> query = em.createQuery("SELECT c from Comment c where c.image.id=:imageId", Comment.class).setParameter("imageId", imageId);;
	        List<Comment> resultList = query.getResultList();

	        return resultList;
	    }
}
