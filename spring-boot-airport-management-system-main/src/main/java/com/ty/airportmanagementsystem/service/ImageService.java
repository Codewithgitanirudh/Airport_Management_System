package com.ty.airportmanagementsystem.service;

import com.ty.airportmanagementsystem.dto.Image;
import com.ty.airportmanagementsystem.response.ApplicationResponse;

public interface ImageService {

	public ApplicationResponse<Image> imageService(Image image);
}
