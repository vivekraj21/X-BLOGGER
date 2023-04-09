package com.springboot.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.payload.CommentDto;
import com.springboot.blog.service.CommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/")
@Tag(
		name = "CRUD REST APIs for Comment Resource"
			)
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Operation(
    		summary = "Create Comment REST API"
    		)
	@PostMapping("/posts/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId,
			@Valid @RequestBody CommentDto commentDto){
		return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);
	}
	
	@Operation(
    		summary = "Get Comment By PostId REST API"
    		)
	@GetMapping("/posts/{postId}/comments")
	public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId){
		return commentService.getCommentsByPostId(postId);
	}
	
	@Operation(
    		summary = "Get Comment By Id REST API"
    		)
	@GetMapping("/posts/{postId}/comments/{id}")
	 public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") long postId,
			 @PathVariable(value = "id") long commentId){
		 CommentDto commentDto = commentService.getCommentById(postId, commentId);
		 return new ResponseEntity<>(commentDto,HttpStatus.OK);
	 }
	
	@Operation(
    		summary = "Update Comment By Id REST API"
    		)
	@PutMapping("/posts/{postId}/comments/{id}")
	public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") long postId,
			@PathVariable(value = "id") long commentId,
			@Valid @RequestBody CommentDto commentDto){
		CommentDto updatedComment = commentService.updateComment(postId, commentId, commentDto);
		return new ResponseEntity<>(updatedComment,HttpStatus.OK);
	}
	
	@Operation(
    		summary = "Delete Comment By Id REST API"
    		)
	@DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") Long postId,
                                                @PathVariable(value = "id") Long commentId){
        commentService.deleteComment(postId, commentId);
        return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
    }
}
