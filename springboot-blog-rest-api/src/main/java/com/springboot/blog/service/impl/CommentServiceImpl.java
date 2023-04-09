package com.springboot.blog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.blog.entity.Comment;
import com.springboot.blog.entity.Post;
import com.springboot.blog.exception.BlogAPIException;
import com.springboot.blog.exception.ResourceNotFoundException;
import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.repository.CommentRepository;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public CommentDto createComment(Long postId, CommentDto commentDto) {
		Comment comment = mapToEntity(commentDto);
		
		//retrieve post entity by id
		Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
		
		// set post to comment entity
		comment.setPost(post);
		
		// save comment entity to database
		Comment newComment = commentRepository.save(comment);
		
		return mapToDTO(newComment);
	}
	
	 private CommentDto mapToDTO(Comment comment){
	        CommentDto commentDto = mapper.map(comment, CommentDto.class);
	        return  commentDto;
	    }

	    private Comment mapToEntity(CommentDto commentDto){
	        Comment comment = mapper.map(commentDto, Comment.class);
	        return  comment;
	    }

		@Override
		public List<CommentDto> getCommentsByPostId(Long postId) {
			// retrieve comment by postId
			List<Comment> comments = commentRepository.findByPostId(postId);
			
			// convert list of comment entities to list of comment dto's
			return comments.stream().map(comment -> mapToDTO(comment)).collect(Collectors.toList());
		}

		@Override
		public CommentDto getCommentById(Long postId, Long commentId) {
			// retrieve post entity by id
			Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));

			//retrieve comment by id
			Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
            new ResourceNotFoundException("Comment", "id", commentId));

            if(!comment.getPost().getId().equals(post.getId())){
                 throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
               }

            return mapToDTO(comment);
			
		}

		@Override
		public CommentDto updateComment(Long postId, Long commentId, CommentDto commentRequest) {
			// retrieve post entity by id
	        Post post = postRepository.findById(postId).orElseThrow(
	                () -> new ResourceNotFoundException("Post", "id", postId));

	        // retrieve comment by id
	        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
	                new ResourceNotFoundException("Comment", "id", commentId));

	        if(!comment.getPost().getId().equals(post.getId())){
	            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
	        }

	        comment.setName(commentRequest.getName());
	        comment.setEmail(commentRequest.getEmail());
	        comment.setBody(commentRequest.getBody());

	        Comment updatedComment = commentRepository.save(comment);
	        return mapToDTO(updatedComment);
		}

		@Override
		public void deleteComment(Long postId, Long commentId) {
			// retrieve post entity by id
	        Post post = postRepository.findById(postId).orElseThrow(
	                () -> new ResourceNotFoundException("Post", "id", postId));

	        // retrieve comment by id
	        Comment comment = commentRepository.findById(commentId).orElseThrow(() ->
	                new ResourceNotFoundException("Comment", "id", commentId));

	        if(!comment.getPost().getId().equals(post.getId())){
	            throw new BlogAPIException(HttpStatus.BAD_REQUEST, "Comment does not belongs to post");
	        }

	        commentRepository.delete(comment);
			
		}
		

}
