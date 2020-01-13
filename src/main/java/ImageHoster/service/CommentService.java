package ImageHoster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ImageHoster.model.Comment;
import ImageHoster.repository.CommentRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	public void createComment(Comment comment)
	{
		commentRepository.createComment(comment);
	}
	
	public List<Comment> getAllCommentsByImageId(Integer imageId)
	{
		return commentRepository.getCommentsByImageId(imageId);
	}
	

}
