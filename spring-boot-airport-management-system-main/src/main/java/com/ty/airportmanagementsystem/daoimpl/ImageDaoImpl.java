package com.ty.airportmanagementsystem.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.airportmanagementsystem.dao.ImageDao;
import com.ty.airportmanagementsystem.dto.Image;
import com.ty.airportmanagementsystem.repository.ImageRepository;

@Repository
public class ImageDaoImpl implements ImageDao{

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public Image insertImageDao(Image image) {
		return imageRepository.save(image);
	}

}
