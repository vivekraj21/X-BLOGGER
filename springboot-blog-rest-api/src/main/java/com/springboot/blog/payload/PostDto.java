package com.springboot.blog.payload;

import java.util.Set;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {
	private long id;
	@NotEmpty
	@Size(min = 2,message = "Post title must have atleast 2 characters")
	private String title;
	@NotEmpty
	@Size(min = 10,message = "Post description must have atleast 10 characters")
	private String description;
	
	@NotEmpty
	private String content;
	private Set<CommentDto> comments; 
	
	private Long categoryId;
}
