package com.bloggingApp.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.aspectj.weaver.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bloggingApp.entitiesDtos.PostDto;
import com.bloggingApp.exceptions.ApiResp;
import com.bloggingApp.services.FileService;
import com.bloggingApp.services.PostService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpServletResponseWrapper;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class PostController {

	@Autowired
	private PostService postService;

	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	String folderPath;
	
//1.create post....................................................................

//http://localhost:8083/api/user/1/category/1/post	
	@PostMapping("/user/{userId}/category/{cateId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,
			                                  @PathVariable Long userId,
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

//8.upload image in post ....................................................................

//http://localhost:8083/api/post/image/upload/1	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> imageUpload(@RequestParam ("postImage") MultipartFile mpf,
		                                       @PathVariable Integer postId )
    {
		
    PostDto postDto = this.postService.getPostByPostId(postId);
		
    String imageName = this.fileService.imageUpload(folderPath, mpf);
    postDto.setpImageName(imageName);
    PostDto updatedPost = this.postService.updatePost(postDto, postId);
	
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
	}
	
	
//9.download image from DB....................................................................

//http:localhost:8083/api/image/download/image nameee	
	@GetMapping("image/download/{imageNameInDB}")
	public void getImageFromProjectFolder(@PathVariable String imageNameInDB,
			                                    HttpServletResponse resp  ) 
	{
    
	    InputStream is = this.fileService.getImageFromProjectFolder(folderPath, imageNameInDB);
		resp.setContentType(MediaType.IMAGE_PNG_VALUE);
		try 
		{
			StreamUtils.copy(is, resp.getOutputStream());
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
	
	
	
	
	
}
