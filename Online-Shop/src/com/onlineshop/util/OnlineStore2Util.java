package com.onlineshop.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import com.onlineshop.constants.Constants;

public class OnlineStore2Util {
	

	public static String uploadImage(UploadedFile image) throws Exception {

		String uploadPathStr = Constants.UPLOAD_DIR;
		
		Path uploadPath = Paths.get(uploadPathStr);
		
		// image.write(pathStr);
		byte[] bytes = null;
		if (image != null) {
			String fileName = image.getFileName();
			String prefix = fileName.substring(0, fileName.lastIndexOf('.'));
			String suffix = fileName.substring(fileName.lastIndexOf('.'));
			Path path = Files.createTempFile(uploadPath, prefix, suffix);
			String tempName = path.getFileName().toString();
			bytes = image.getContents();
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(uploadPathStr + tempName)));
			stream.write(bytes);
			stream.close();
			return tempName;
		} else {return null;}

	}
	
	public static void sucessMessage(String componentID, String message){
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage("Success", message);
		context.addMessage(componentID, msg);

	}


}
