package com.img.app.repository;

import java.awt.image.BufferedImage;

import com.img.app.controller.model.ImgModel;

public interface ImageRespository {
	
	ImgModel<BufferedImage> getImage(Integer groupId, Integer memberId);

}
