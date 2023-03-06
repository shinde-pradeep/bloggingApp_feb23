package com.bloggingApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bloggingApp.entities.Category;
import com.bloggingApp.entities.Post;
import com.bloggingApp.entities.User;

public interface PostRepo extends JpaRepository<Post,Integer> {

//as JpaRepository interface extends ListCrudRepository<T, ID> interface...it has CRUD methods only
//create customize methods in repository...to perform any other operation than CRUD

	
//so create customized methods...similar to the method "getById" of ListCrudRepository interface
	
	List<Post> getByUser (User user);
	
	List<Category> getByCategory (Category category);
	
	
	
}
