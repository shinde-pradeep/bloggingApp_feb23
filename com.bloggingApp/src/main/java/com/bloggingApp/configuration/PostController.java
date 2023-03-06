package com.bloggingApp.configuration;

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

import com.bloggingApp.entitiesDtos.PostDto;
import com.bloggingApp.exceptions.ApiResp;
import com.bloggingApp.services.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;

	
//1.create post....................................................................

//http://localhost:8083/api/user/1/category/1/post	
	@PostMapping("/user/{userId}/category/{cateId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long userId,
			@PathVariable Integer cateId) {

		PostDto createdPost = this.postService.createPost(postDto, userId, cateId);

		return new ResponseEntity<PostDto>(createdPost, HttpStatus.CREATED);

	}
	
//2.update post....................................................................
	
//http://localhost:8083/api/1/post		
		@PutMapping("/{postId}/post")
		public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto,@PathVariable Integer postId) {
			
			PostDto updatedPost = this.postService.updatePost(postDto, postId);
			
			return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
		}
		

//3.get/find posts by id post....................................................................

//http://localhost:8083/api/1/post		
	@GetMapping("/{postId}/post")
	public ResponseEntity<PostDto> getPostByPostId(@PathVariable Integer postId) {

		PostDto post = this.postService.getPostByPostId(postId);
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);

	}
	
//4.delete post....................................................................

//http://localhost:8083/api/1/post	
	@DeleteMapping("/{postId}/post")
	public ResponseEntity <ApiResp> deletePostByPostId(@PathVariable Integer postId) {	
	
		this.postService.deletePostByPostId(postId);
		return new ResponseEntity<ApiResp>(new ApiResp("post deleted successfully",true),HttpStatus.OK);
	}
	
//5.get/find all posts....................................................................

//http://localhost:8083/api/posts
	    @GetMapping("/posts")
		public ResponseEntity <List<PostDto>> getAllPosts() {
			
	    List<PostDto> posts = this.postService.getAllPosts();	
		return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

		}

//6.get/find post by user id....................................................................

//http://localhost:8083/api/user/1/posts
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostsByUser(@PathVariable Long userId) {

		List<PostDto> postsByUser = this.postService.getAllPostsByUser(userId);
		return new ResponseEntity<List<PostDto>>(postsByUser, HttpStatus.OK);
	}

//7.get/find post by category id....................................................................

//http://localhost:8083/api/category/1/posts
	@GetMapping("/category/{catId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable Integer catId) {

		List<PostDto> postsByCat = this.postService.getAllPostsByCategory(catId);
		return new ResponseEntity<List<PostDto>>(postsByCat, HttpStatus.OK);
	}

}
