package com.ty.airportmanagementsystem.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.airportmanagementsystem.dao.ImageDao;
import com.ty.airportmanagementsystem.dto.Image;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.ImageService;

import jakarta.servlet.http.HttpSession;

@Service
public class ImageServiceImpl implements ImageService{

	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private ApplicationResponse<Image> applicationResponse;
//	
//	@Autowired
//	private HttpSession httpSession;
//	
	@Override
	public ApplicationResponse<Image> imageService(Image image) {
		Image img = imageDao.insertImageDao(image);
		if(img != null) {
			applicationResponse.setStatusCode(HttpStatus.ACCEPTED.value());
			applicationResponse.setMessage("imaged-stored-successfully");
			applicationResponse.setDescription("you can follow below data what is added inside table");
			applicationResponse.setData(image);
			return applicationResponse;
		}else {
			applicationResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			applicationResponse.setMessage("image-storation--unsuccesfull");
			applicationResponse.setDescription("check sql query or database");
			applicationResponse.setData(null);
			return applicationResponse;
		}
	}

}
