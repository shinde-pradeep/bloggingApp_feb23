package com.bloggingApp.services;

import java.util.List;

import com.bloggingApp.entities.Category;
import com.bloggingApp.entities.Post;
import com.bloggingApp.entities.User;
import com.bloggingApp.entitiesDtos.PostDto;

public interface PostService {
	
// 1 post must have connected to 1 user & 1 category...so enter userId & catId while creating the post
	PostDto createPost (PostDto post,Long userId, Integer cateId);
	
	PostDto updatePost (PostDto post,Integer postId);
	
	PostDto getPostByPostId (Integer postId);
	
	void deletePostByPostId (Integer postId);
	
	List<PostDto> getAllPosts ();
	
//.................................................................
	
	
	List<PostDto> getAllPostsByUser (Long userId);
	
	List<PostDto> getAllPostsByCategory(Integer catId);

	List<PostDto> searchPosts (String postContent);
	
	
	
	
	
	
	
	
	
	

}
