package com.bloggingApp.servicesImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bloggingApp.services.FileService;

@Service
public class FileServiceImpl implements FileService{

//8.upload image in post ....................................................................
	
	@Override
	public String imageUpload(String folderPath, MultipartFile mpf) {

//1.get file name from client's system
		
		String fileNameAsInClientSystem = mpf.getOriginalFilename();
		                                           System.out.println("original image name -"+fileNameAsInClientSystem);
		
//1.2.change file name to a random name...
      //...while developing html page refer random name to get that image/file...general info...this is written in note of getOriginalFilename() method (to read get courser on this method name) 		
		
		String randomUUID = UUID.randomUUID().toString();
		String randomFileName = randomUUID.concat(fileNameAsInClientSystem.substring(fileNameAsInClientSystem.lastIndexOf(".")));
		                                          System.out.println("random image name -"+randomFileName);

//2.find FULL file path
	// full path contains -> folder path + \ + file name
		
		String fullFilePath = folderPath + File.separator + fileNameAsInClientSystem; // change 1
		
		
//3.open connection to file 		

	File openConnectionTo =new File(folderPath);	
		
//3.1.if file not available then create one
		if(!openConnectionTo.exists())
		{
			openConnectionTo.mkdir();
		}
		
		
//4.copy file
		
		try 
		{
			Files.copy(mpf.getInputStream(), Paths.get(fullFilePath));
		} 
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//return file name (original i.e. clientsSystemFileName	or random name...as per our requirement
		
		return fileNameAsInClientSystem;
	}
	

	
//9.download image from DB....................................................................
	
	@Override
	public InputStream getImageFromProjectFolder(String fileFolderPath, String imageName) {

    String fileFullPath = fileFolderPath+File.separator+imageName;
    
    InputStream readFileIS = null;
    try 
    {
		 readFileIS = new FileInputStream(fileFullPath);
	}
    catch (FileNotFoundException e) 
    {
		e.printStackTrace();
	}
		
		
		return readFileIS;
	}

}
