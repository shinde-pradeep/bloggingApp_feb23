package com.bloggingApp.services;

import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {


// pathImageFolder -> path of folder in project where image is going to store/upload
	
	String imageUpload (String folderPath, MultipartFile mpf);

	
// pathImageFolder -> path of folder in project where image is stored/uploaded
// imageName -> that folder can have multiple images so image name to get particular image 	
	
	InputStream getImageFromProjectFolder(String folderPath, String imageName);
}
