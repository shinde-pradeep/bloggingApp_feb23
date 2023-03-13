package com.bloggingApp.servicesImpl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.aspectj.weaver.ast.Not;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.asm.Advice.This;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloggingApp.entities.Category;
import com.bloggingApp.entities.Post;
import com.bloggingApp.entities.User;
import com.bloggingApp.entitiesDtos.CategoryDto;
import com.bloggingApp.entitiesDtos.PostDto;
import com.bloggingApp.exceptions.ResourceNotFoundExceptionnn;
import com.bloggingApp.repositories.CategoryRepo;
import com.bloggingApp.repositories.PostRepo;
import com.bloggingApp.repositories.UserRepo;
import com.bloggingApp.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	

//1.create post....................................................................
	
	@Override
	public PostDto createPost(PostDto postDto, Long userId, Integer cateId) {

	  	User user         = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExceptionnn("user","user id", userId));
		Category category = this.categoryRepo.findById(cateId).orElseThrow(()->new ResourceNotFoundExceptionnn("cate","cate id", cateId));
	
		Post post = this.modelMapper.map(postDto, Post.class);
		
		post.setpTitle(postDto.getpTitle());
		post.setpContent(postDto.getpContent());
		post.setpImageName("default.png");
		post.setpAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		
		Post createdPost = this.postRepo.save(post);
		
		PostDto converted_createdPost = this.modelMapper.map(createdPost,PostDto.class);	
		return converted_createdPost;
	}
	
//2.update post....................................................................
	

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {

		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundExceptionnn("post","post id",postId));
				
		post.setpTitle(postDto.getpTitle());
		post.setpContent(postDto.getpContent());
		post.setpImageName("default.png");
		post.setpAddedDate(new Date());
	
		Post updatedPost = this.postRepo.save(post);
		
		PostDto converted_updatedPost = this.modelMapper.map(updatedPost,PostDto.class);	
		return converted_updatedPost;
		
	}

	
//3.get/find posts by id post....................................................................

	@Override
	public PostDto getPostByPostId(Integer postId) {

		Post post=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundExceptionnn("post", "post id",postId));
		PostDto convert_postById=this.modelMapper.map(post, PostDto.class);
		return convert_postById;
	}

//4.delete post....................................................................

	@Override
	public void deletePostByPostId(Integer postId) {
		Post postToDelete=this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundExceptionnn("post", "post id",postId));
		this.postRepo.delete(postToDelete);
	}

//5.get/find all posts....................................................................

	@Override
	public List<PostDto> getAllPosts() {
     
		List<Post> allPosts=this.postRepo.findAll();
        List<PostDto> allPostsToDtos=allPosts.stream().map((po)->this.modelMapper.map(po,PostDto.class))
        		                             .collect(Collectors.toList());

        return allPostsToDtos;
	}
	
//6.get/find post by user id....................................................................

	@Override
	public List<PostDto> getAllPostsByUser(Long userId) {

        User user=this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundExceptionnn("user","user id",userId));
		List<Post> allPostByUser=this.postRepo.getByUser(user); 
	
		List<PostDto> converted_allPostByUser = allPostByUser.stream().map((post1)->this.modelMapper.map(post1,PostDto.class)).collect(Collectors.toList());
		return converted_allPostByUser;
	}

//7.get/find post by category id....................................................................

	@Override
	public List<PostDto> getAllPostsByCategory(Integer catId) {
		
		 Category category=this.categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundExceptionnn("category","category id",catId));
		 List<Category> allPostByCategory=this.postRepo.getByCategory(category); 
		
	   	 List<PostDto> converted_allPostByCategory = allPostByCategory.stream().map((po)->this.modelMapper.map(po,PostDto.class)).collect(Collectors.toList());
		 return converted_allPostByCategory;
		 
	}

//8.get/find/search post by post content .............................................................

	@Override
	public List<PostDto> searchPosts(String postContent) {
		// TODO Auto-generated method stub
		return null;
	}

}
