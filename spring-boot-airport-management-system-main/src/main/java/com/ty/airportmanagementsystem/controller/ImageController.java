package com.ty.airportmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.airportmanagementsystem.dto.Image;
import com.ty.airportmanagementsystem.response.ApplicationResponse;
import com.ty.airportmanagementsystem.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {
	
	@Autowired
	private ImageService imageService;
	
	@PostMapping()
	public ApplicationResponse<Image> imageController(@RequestParam Image image){
		return imageService.imageService(image);
	}
}
